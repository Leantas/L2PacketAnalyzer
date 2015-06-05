/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.fastlogin;

import static java.nio.charset.StandardCharsets.US_ASCII;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.file.NoSuchFileException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.ParserConfigurationException;

import net.l2emuproject.network.ClientProtocolVersion;
import net.l2emuproject.network.IGameProtocolVersion;
import net.l2emuproject.network.mmocore.MMOBuffer;
import net.l2emuproject.proxy.network.Packet;
import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.network.game.server.L2GameServer;
import net.l2emuproject.proxy.network.login.client.L2LoginClient;
import net.l2emuproject.proxy.network.login.server.L2LoginServer;
import net.l2emuproject.proxy.network.meta.RandomAccessMMOBuffer;
import net.l2emuproject.proxy.network.packets.ProxyRepeatedPacket;
import net.l2emuproject.proxy.script.ScriptFieldAlias;
import net.l2emuproject.proxy.script.game.GameScript;
import net.l2emuproject.proxy.script.game.PpeEnabledGameScript;
import net.l2emuproject.proxy.script.login.LoginScript;
import net.l2emuproject.proxy.ui.savormix.io.base.IOConstants;
import net.l2emuproject.security.LoginCipher;
import net.l2emuproject.security.ScrambledRSAKeyPair;
import net.l2emuproject.util.L2XMLUtils;
import net.l2emuproject.util.concurrent.L2ThreadPool;
import net.l2emuproject.util.logging.L2Logger;

import org.apache.commons.lang3.ArrayUtils;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import util.packet.CommonPacketSender;

import eu.revengineer.simplejse.HasScriptDependencies;
import eu.revengineer.simplejse.type.UnloadableScript;

/**
 * A script that allows users to input fake credentials while logging in. Obscure e-mail addresses and secure passwords may be used without
 * sacrificing the ability to 9+ box different account sets in seconds.<BR>
 * <BR>
 * In other words, you can input 'a' as user and 'b' as password, and NetPro will supply 'username@email.xxx' & 'real_long_password' to the login server.<BR>
 * Configuration file is located in {@code [user.home]/l2emu-unique-netpro/fast_login_credentials.xml}.<BR>
 * <BR>
 * You may also configure your character selection PINs and/or security card codes for automatic input (if you play on a server where such are used).<BR>
 * There is no XSD/schema at this time, so look at {@code loadCredentials()} on how to write the configuration XML.<BR>
 * <BR>
 * Furthermore, this script can be used on very old servers [Prelude - C3]. Unfortunately, there will surely be problems with servers between C4 (inclusive) and
 * C5 latest update (exclusive), as they were completely untested and likely to use different methods AND offsets.<BR>
 * IL and later should be fine, but not all clients have been tested.
 * 
 * @author _dev_
 */
@HasScriptDependencies("util.packet.CommonPacketSender")
public final class FastLogin extends LoginScript implements IOConstants, UnloadableScript
{
	private static final L2Logger LOG = L2Logger.getLogger(FastLogin.class);
	
	private static final int OP_AQ_LOGIN = 0x00, OP_REQ_SC_CHECK = 0x06;
	private static final int OP_SET_ENC = 0x00, OP_SC_CHECK_REQ = 0x0A;
	
	// Client: handle user data, handle SC key input (if card is not configured)
	// Server: handle RSA key, [optionally] handle SC
	private static final int[] OPCODES_CLIENT = { OP_AQ_LOGIN, OP_REQ_SC_CHECK }, OPCODES_SERVER = { OP_SET_ENC, OP_SC_CHECK_REQ };
	static final int[] STEALTH_OPCODES = { 0x2B };
	
	private static final int BLOCK_SIZE_RSA = 128;
	private static final int BLOCK_SIZE_PLAIN_USER_LEGACY = 14, BLOCK_SIZE_PLAIN_USER_NEWEST = 50;
	private static final int BLOCK_SIZE_PLAIN_PASSWORD = 16;
	private static final int BLOCK_OFFSET_LEGACY = 0;
	private static final int BLOCK_OFFSET_USER = 0x5E, BLOCK_OFFSET_PASS = 0x6C;
	private static final int BLOCK_OFFSET_USER_NEWEST = 0x4E, BLOCK_OFFSET_PASS_NEWEST = 0x5C;
	private static final int BLOCK_OFFSET_SC_KEY = 0x05;
	
	private final Map<String, Credentials> _fakeUsers;
	private final Map<String, String> _accountPINs;
	
	private final ScrambledRSAKeyPair _interceptionKeyPair;
	
	private final Map<L2LoginClient, LoginAttempt> _rsaKeys;
	
	// helper classes
	private final AccountDataProvider _inputToRealAccountNameTranslator;
	private final HideFastLogin _stealthPlugin;
	private final FastPIN _characterPinPlugin;
	
	/** Constructs this script. */
	public FastLogin()
	{
		super(OPCODES_CLIENT, OPCODES_SERVER);
		
		_fakeUsers = new HashMap<>();
		_accountPINs = new HashMap<>();
		loadCredentials();
		
		KeyPair kp = null;
		try
		{
			final KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
			rsa.initialize(new RSAKeyGenParameterSpec(1024, RSAKeyGenParameterSpec.F4));
			
			kp = rsa.generateKeyPair();
		}
		catch (GeneralSecurityException e)
		{
			LOG.error("Fast login will not be available.", e);
		}
		
		_interceptionKeyPair = kp != null ? new ScrambledRSAKeyPair(kp) : null;
		
		_rsaKeys = new ConcurrentHashMap<>();
		
		_inputToRealAccountNameTranslator = new AccountDataProvider();
		_stealthPlugin = new HideFastLogin();
		_characterPinPlugin = new FastPIN();
		
		// attempt to minimize impact when having to modify the first packet
		try
		{
			Cipher.getInstance("RSA/ECB/nopadding");
			KeyFactory.getInstance("RSA");
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	private void loadCredentials()
	{
		try
		{
			final int[] scKeyList = new int[32];
			for (final Node acc : L2XMLUtils.listNodesByNodeName(L2XMLUtils.getChildNodeByName(L2XMLUtils.getXMLFile(APPLICATION_DIRECTORY.resolve("fast_login_credentials.xml")), "credentials"),
					"account"))
			{
				final String alias = L2XMLUtils.getString(acc, "fakeName").toLowerCase(Locale.ENGLISH);
				final String user = L2XMLUtils.getString(acc, "user").toLowerCase(Locale.ENGLISH);
				final String pass = L2XMLUtils.getString(acc, "pass");
				final Node sc = L2XMLUtils.getChildNodeByName(acc, "card");
				int sz = 0;
				if (sc != null)
				{
					for (Node key : L2XMLUtils.listNodesByNodeName(sc, "key"))
					{
						try
						{
							scKeyList[sz] = Integer.parseInt(key.getTextContent());
						}
						catch (NumberFormatException e)
						{
							scKeyList[sz] = -1; // emulated client behavior
						}
						++sz;
					}
				}
				final int[] scKeys;
				if (sz > 0)
				{
					scKeys = new int[sz];
					System.arraycopy(scKeyList, 0, scKeys, 0, sz);
				}
				else
					scKeys = ArrayUtils.EMPTY_INT_ARRAY;
				_fakeUsers.put(alias, new Credentials(user, pass, scKeys));
				
				final String pin = L2XMLUtils.getString(acc, "pin", null);
				if (pin != null)
					_accountPINs.put(user, pin);
			}
		}
		catch (NoSuchFileException | FileNotFoundException e)
		{
			LOG.info("Fast login configuration file is missing.");
		}
		catch (IOException | ParserConfigurationException | SAXException e)
		{
			LOG.error("Fast login will not be available.", e);
			_fakeUsers.clear();
			_accountPINs.clear();
		}
	}
	
	@Override
	protected void connectionTerminated(L2LoginClient client, L2LoginServer server)
	{
		super.connectionTerminated(client, server);
		
		if (client != null)
			_rsaKeys.remove(client);
	}
	
	@Override
	protected void serverPacketArrived(L2LoginServer sender, L2LoginClient recipient, Packet packet)
	{
		if (_interceptionKeyPair == null || _fakeUsers.isEmpty())
			return;
		
		final ByteBuffer buf = packet.getDefaultBufferForModifications();
		if (buf.get(0) == OP_SC_CHECK_REQ)
		{
			// TODO: deal with legacy SC (unenciphered)
			
			buf.position(1);
			final int accountID = buf.getInt();
			final int key = buf.get() - 1;
			
			final LoginAttempt la = _rsaKeys.get(recipient);
			if (la._userData == null || key >= la._userData._scKeys.length)
				return; // unknown user or SC key, await manual entry
			
			// as proxy only deals with client-constructed packets, we must pre-allocate padding
			final ByteBuffer response = ByteBuffer.allocate(BLOCK_OFFSET_SC_KEY + BLOCK_SIZE_RSA + 3 + 16).order(buf.order());
			response.put((byte)OP_REQ_SC_CHECK).putInt(accountID).limit(BLOCK_OFFSET_SC_KEY + BLOCK_SIZE_RSA).position(response.limit() - BLOCK_OFFSET_SC_KEY);
			response.put((byte)4).putInt(la._userData._scKeys[key]);
			try
			{
				final Cipher rsa = Cipher.getInstance("RSA/ECB/nopadding");
				final KeyFactory kf = KeyFactory.getInstance("RSA");
				rsa.init(Cipher.ENCRYPT_MODE, kf.generatePublic(new RSAPublicKeySpec(la.getModulus(), RSAKeyGenParameterSpec.F4)));
				response.position(BLOCK_OFFSET_SC_KEY);
				response.put(rsa.doFinal(response.array(), BLOCK_OFFSET_SC_KEY, BLOCK_SIZE_RSA));
			}
			catch (GeneralSecurityException e)
			{
				LOG.error("Failed to decipher/reencipher a security card key!", e);
				return;
			}
			// prematurely inject checksum so that it would be available for notifications
			{
				response.clear();
				LoginCipher.injectChecksum(response, 16); // client packet checksum scheme
			}
			sender.sendPacket(new ProxyRepeatedPacket(response.array()));
			// we have not fired an async notification for the packet that is being currently handled, so fire the response packet notification later
			final long time = System.currentTimeMillis();
			L2ThreadPool.execute(() -> recipient.notifyPacketForwarded(null, response, time));
			return;
		}
		
		buf.position(1 + 8);
		if (buf.remaining() < 128)
			return;
		
		final byte[] modulus = new byte[BLOCK_SIZE_RSA];
		{
			//buf.position(1 + 8);
			buf.get(modulus);
		}
		_rsaKeys.put(recipient, new LoginAttempt(modulus));
		{
			buf.position(1 + 8);
			buf.put(_interceptionKeyPair.getScrambledModulus());
		}
		packet.setForwardedBody(buf);
	}
	
	@Override
	protected void clientPacketArrived(L2LoginClient sender, L2LoginServer recipient, Packet packet)
	{
		if (_interceptionKeyPair == null || _fakeUsers.isEmpty())
			return;
		
		final ByteBuffer buf = packet.getDefaultBufferForModifications();
		
		if (buf.get(0) == OP_REQ_SC_CHECK)
		{
			// TODO: deal with legacy SC (unenciphered)
			// manual SC key entry, must ALWAYS reencipher
			byte[] keyBlock = new byte[BLOCK_SIZE_RSA];
			buf.position(BLOCK_OFFSET_SC_KEY);
			buf.get(keyBlock);
			
			try
			{
				final Cipher rsa = Cipher.getInstance("RSA/ECB/nopadding");
				rsa.init(Cipher.DECRYPT_MODE, _interceptionKeyPair.getPair().getPrivate());
				keyBlock = rsa.doFinal(keyBlock, 0, BLOCK_SIZE_RSA);
				
				final KeyFactory kf = KeyFactory.getInstance("RSA");
				rsa.init(Cipher.ENCRYPT_MODE, kf.generatePublic(new RSAPublicKeySpec(_rsaKeys.get(sender).getModulus(), RSAKeyGenParameterSpec.F4)));
				buf.position(BLOCK_OFFSET_SC_KEY);
				buf.put(rsa.doFinal(keyBlock));
				
				packet.setForwardedBody(buf);
			}
			catch (GeneralSecurityException e)
			{
				LOG.error("Failed to decipher/reencipher a security card key!", e);
				return;
			}
			return;
		}
		
		buf.position(1);
		
		if (buf.remaining() < BLOCK_SIZE_RSA)
		{
			// legacy protocol, easier to understand when not an integral part of the algorithm
			// therefore some copy-pasted code
			final byte[] userBlock = new byte[BLOCK_SIZE_PLAIN_USER_LEGACY], passBlock = new byte[BLOCK_SIZE_PLAIN_PASSWORD];
			buf.get(userBlock).get(passBlock);
			final String fakeName = new String(userBlock, BLOCK_OFFSET_LEGACY, BLOCK_SIZE_PLAIN_USER_LEGACY, US_ASCII).trim().toLowerCase();
			final Credentials realData = _fakeUsers.get(fakeName);
			if (realData == null)
				return;
			
			ByteBuffer writer;
			{
				writer = ByteBuffer.wrap(userBlock, BLOCK_OFFSET_LEGACY, BLOCK_SIZE_PLAIN_USER_LEGACY);
				for (int i = 0; i < writer.remaining(); ++i)
					writer.put(writer.position() + i, (byte)0);
				writer.put(realData._account.getBytes(US_ASCII));
			}
			{
				writer = ByteBuffer.wrap(passBlock, BLOCK_OFFSET_LEGACY, BLOCK_SIZE_PLAIN_PASSWORD);
				for (int i = 0; i < writer.remaining(); ++i)
					writer.put(writer.position() + i, (byte)0);
				writer.put(realData._password.getBytes(US_ASCII));
			}
			
			buf.position(1);
			buf.put(userBlock).put(passBlock);
			packet.setForwardedBody(buf);
			return;
		}
		
		byte[] userBlock = new byte[BLOCK_SIZE_RSA], passBlock = null;
		buf.get(userBlock);
		if (buf.remaining() >= BLOCK_SIZE_RSA)
		{
			passBlock = new byte[BLOCK_SIZE_RSA];
			buf.get(passBlock);
		}
		
		try
		{
			final Cipher rsa = Cipher.getInstance("RSA/ECB/nopadding");
			rsa.init(Cipher.DECRYPT_MODE, _interceptionKeyPair.getPair().getPrivate());
			
			userBlock = rsa.doFinal(userBlock, 0, BLOCK_SIZE_RSA);
			final Credentials realData;
			replaceData: if (passBlock != null)
			{
				passBlock = rsa.doFinal(passBlock, 0, BLOCK_SIZE_RSA);
				
				final String fakeName = new String(userBlock, BLOCK_OFFSET_USER_NEWEST, BLOCK_SIZE_PLAIN_USER_NEWEST, US_ASCII).trim().toLowerCase();
				realData = _fakeUsers.get(fakeName);
				if (realData == null)
					break replaceData;
				
				ByteBuffer writer;
				{
					writer = ByteBuffer.wrap(userBlock, BLOCK_OFFSET_USER_NEWEST, BLOCK_SIZE_PLAIN_USER_NEWEST);
					for (int i = 0; i < writer.remaining(); ++i)
						writer.put(writer.position() + i, (byte)0);
					writer.put(realData._account.getBytes(US_ASCII));
				}
				{
					writer = ByteBuffer.wrap(passBlock, BLOCK_OFFSET_PASS_NEWEST, BLOCK_SIZE_PLAIN_PASSWORD);
					for (int i = 0; i < writer.remaining(); ++i)
						writer.put(writer.position() + i, (byte)0);
					writer.put(realData._password.getBytes(US_ASCII));
				}
			}
			else
			{
				final String fakeName = new String(userBlock, BLOCK_OFFSET_USER, BLOCK_SIZE_PLAIN_USER_LEGACY, US_ASCII).trim().toLowerCase();
				realData = _fakeUsers.get(fakeName);
				if (realData == null)
					break replaceData;
				
				ByteBuffer writer;
				{
					writer = ByteBuffer.wrap(userBlock, BLOCK_OFFSET_USER, BLOCK_SIZE_PLAIN_USER_LEGACY);
					for (int i = 0; i < writer.remaining(); ++i)
						writer.put(writer.position() + i, (byte)0);
					writer.put(realData._account.getBytes(US_ASCII));
				}
				{
					writer = ByteBuffer.wrap(userBlock, BLOCK_OFFSET_PASS, BLOCK_SIZE_PLAIN_PASSWORD);
					for (int i = 0; i < writer.remaining(); ++i)
						writer.put(writer.position() + i, (byte)0);
					writer.put(realData._password.getBytes(US_ASCII));
				}
			}
			
			final LoginAttempt la = _rsaKeys.get(sender);
			la._userData = realData;
			final KeyFactory kf = KeyFactory.getInstance("RSA");
			rsa.init(Cipher.ENCRYPT_MODE, kf.generatePublic(new RSAPublicKeySpec(la.getModulus(), RSAKeyGenParameterSpec.F4)));
			
			buf.position(1);
			buf.put(userBlock = rsa.doFinal(userBlock));
			if (passBlock != null)
				buf.put(passBlock = rsa.doFinal(passBlock));
			
			packet.setForwardedBody(buf);
		}
		catch (GeneralSecurityException e)
		{
			LOG.error("Failed to decipher/reencipher account credentials!", e);
			return;
		}
	}
	
	@Override
	public String getScriptName()
	{
		return "Fast login with fake credentials";
	}
	
	@Override
	public String getAuthor()
	{
		return "_dev_";
	}
	
	@Override
	public String getVersionString()
	{
		return "Mid-C5 login update and above";
	}
	
	Map<String, String> getAccountPINs()
	{
		return _accountPINs;
	}
	
	String toRealAccount(String clientLogonName)
	{
		final Credentials realData = _fakeUsers.get(clientLogonName);
		return realData != null ? realData._account : clientLogonName;
	}
	
	@Override
	public void onLoad() throws RuntimeException
	{
		super.onLoad();
		
		_inputToRealAccountNameTranslator.onLoad();
		_stealthPlugin.onLoad();
		_characterPinPlugin.onLoad();
	}
	
	@Override
	public void onUnload() throws RuntimeException
	{
		super.onUnload();
		
		_inputToRealAccountNameTranslator.onUnload();
		_stealthPlugin.onUnload();
		_characterPinPlugin.onUnload();
	}
	
	private static final class Credentials
	{
		final String _account, _password;
		final int[] _scKeys;
		
		Credentials(String account, String password, int... scKeys)
		{
			_account = account;
			_password = password;
			_scKeys = scKeys;
		}
	}
	
	private static final class LoginAttempt
	{
		private final byte[] _rsaKey;
		Credentials _userData;
		
		LoginAttempt(byte[] rsaKey)
		{
			_rsaKey = rsaKey;
		}
		
		BigInteger getModulus()
		{
			return ScrambledRSAKeyPair.unscrambleModulus(_rsaKey.clone());
		}
	}
	
	/**
	 * Associates an account name with the game client.
	 * 
	 * @author _dev_
	 */
	class AccountDataProvider extends PpeEnabledGameScript
	{
		@ScriptFieldAlias
		private static final String ACCOUNT_NAME = "adp_account_name";
		
		@Override
		public String getName()
		{
			return "Account data provider";
		}
		
		@Override
		public void handleClientPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
		{
			final String clientLogonName = buf.readFirstString(ACCOUNT_NAME).toLowerCase(Locale.ENGLISH);
			client.setAccount(toRealAccount(clientLogonName));
		}
		
		@Override
		public void handleServerPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
		{
			// do nothing here
		}
	}
	
	/**
	 * Automatically inputs character selection PIN code, if applicable.
	 * 
	 * @author _dev_
	 */
	class FastPIN extends PpeEnabledGameScript
	{
		@ScriptFieldAlias
		private static final String DIALOG_TYPE = "fast_login_pin_dialog";
		
		private final Set<L2GameClient> _attempted;
		
		public FastPIN()
		{
			_attempted = Collections.newSetFromMap(new ConcurrentHashMap<>());
		}
		
		@Override
		public void handleDisconnection(L2GameClient client)
		{
			super.handleDisconnection(client);
			
			_attempted.remove(client);
		}
		
		@Override
		public void handleClientPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
		{
			// do nothing here
		}
		
		@Override
		public void handleServerPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer rab) throws RuntimeException
		{
			final String account = client.getAccount();
			if (account == null || rab.readFirstInteger32(DIALOG_TYPE) != 1 || !_attempted.add(client))
				return;
			
			final String pin = getAccountPINs().get(account);
			if (pin == null)
				return;
			
			final IGameProtocolVersion pv = client.getProtocol();
			if (!pv.isNewerThanOrEqualTo(ClientProtocolVersion.VALIANCE))
				return;
			
			final int size = 3 + CommonPacketSender.stdStringSize(pin);
			final ByteBuffer bb = CommonPacketSender.allocate(size);
			final MMOBuffer buf = CommonPacketSender.allocate(bb);
			buf.writeC(0xD0);
			buf.writeH(pv.isNewerThanOrEqualTo(ClientProtocolVersion.ERTHEIA) ? 0xA7 : 0xAB);
			buf.writeS(pin);
			server.sendPacket(new ProxyRepeatedPacket(bb));
			client.notifyPacketForwarded(null, bb, System.currentTimeMillis());
		}
		
		@Override
		public String getName()
		{
			return "Fast PIN";
		}
	}
	
	/**
	 * Hides the actual username input via the client from the game server. Replaces with the real username (email) instead.
	 * 
	 * @author _dev_
	 */
	class HideFastLogin extends GameScript
	{
		public HideFastLogin()
		{
			super(STEALTH_OPCODES, null);
		}
		
		@Override
		protected void clientPacketArrived(L2GameClient sender, L2GameServer recipient, Packet packet)
		{
			if (recipient.getProtocol().isOlderThan(ClientProtocolVersion.THE_KAMAEL))
				return; // FIXME: test opcodes!
			
			final String clientLoginName;
			final ByteBuffer old = packet.getForwardedBody();
			final MMOBuffer buf = new MMOBuffer();
			{
				old.position(1);
				buf.setByteBuffer(old);
				clientLoginName = buf.readS().toLowerCase(Locale.ENGLISH);
			}
			
			final String realName = toRealAccount(clientLoginName);
			if (realName == null || clientLoginName.equals(realName))
				return;
			
			final int extraBytes = CommonPacketSender.stdStringSize(realName) - CommonPacketSender.stdStringSize(clientLoginName);
			final ByteBuffer bb = ByteBuffer.allocate(old.capacity() + extraBytes).order(old.order());
			bb.put(old.get(0));
			{
				buf.setByteBuffer(bb);
				buf.writeS(realName);
			}
			bb.put(old);
			
			packet.setForwardedBody(bb);
		}
		
		@Override
		public String getScriptName()
		{
			return "Fast login stealth plugin";
		}
		
		@Override
		public String getAuthor()
		{
			return "_dev_";
		}
		
		@Override
		public String getVersionString()
		{
			return "Any throne GS";
		}
	}
}
