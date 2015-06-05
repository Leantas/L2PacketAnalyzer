/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import net.l2emuproject.network.ClientProtocolVersion;
import net.l2emuproject.network.IGameProtocolVersion;
import net.l2emuproject.network.mmocore.MMOBuffer;
import net.l2emuproject.proxy.network.Packet;
import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.network.game.server.L2GameServer;
import net.l2emuproject.proxy.network.meta.EnumeratedPayloadField;
import net.l2emuproject.proxy.network.meta.RandomAccessMMOBuffer;
import net.l2emuproject.proxy.network.meta.SimplePpeProvider;
import net.l2emuproject.proxy.network.meta.exception.InvalidPacketOpcodeSchemeException;
import net.l2emuproject.proxy.network.meta.exception.PartialPayloadEnumerationException;
import net.l2emuproject.proxy.script.game.GameScript;
import net.l2emuproject.proxy.ui.savormix.io.base.IOConstants;
import net.l2emuproject.util.logging.L2Logger;

/**
 * This script is designed to counter spam bots in chronicles where after the friend chat exploits have been fixed.
 * 
 * @author _dev_
 */
public class AntiSpam extends GameScript implements IOConstants
{
	private static final L2Logger LOG = L2Logger.getLogger(AntiSpam.class);
	
	private static final int SAY_2 = 0x4A, LEGACY_SAY_2 = 0x5D;
	
	private final Set<Pattern> _patterns;
	
	/** Constructs this packet manipulator. */
	public AntiSpam()
	{
		super(null, new int[] { SAY_2, LEGACY_SAY_2 });
		
		_patterns = new HashSet<>();
		
		try (final BufferedReader br = Files.newBufferedReader(SCRIPT_CONFIG_DIRECTORY.resolve("chat_filter.txt")))
		{
			for (String line; (line = br.readLine()) != null;)
			{
				if (line.isEmpty())
					continue;
				
				try
				{
					_patterns.add(Pattern.compile(line, Pattern.CASE_INSENSITIVE));
				}
				catch (PatternSyntaxException e)
				{
					LOG.info("Invalid pattern: " + line, e);
				}
			}
		}
		catch (NoSuchFileException e)
		{
			LOG.info("Chat pattern list file is missing.");
		}
		catch (IOException e)
		{
			LOG.error("Cannot load chat patterns", e);
		}
	}
	
	@Override
	protected void serverPacketArrived(L2GameServer sender, L2GameClient recipient, Packet packet) throws RuntimeException
	{
		if (_patterns.isEmpty())
			return;
		
		// this simple script will not interfere with anything at all
		if (packet.isLossForced() || packet.isImmutable() || packet.isSendForced())
			return;
		
		final IGameProtocolVersion protocol = recipient.getProtocol();
		final int expectedOpcode = protocol.isNewerThanOrEqualTo(ClientProtocolVersion.C2_AGE_OF_SPLENDOR) ? SAY_2 : LEGACY_SAY_2;
		
		final ByteBuffer body = packet.getForwardedBody();
		if (body.get(0) != expectedOpcode)
			return;
		
		final RandomAccessMMOBuffer buf;
		try
		{
			buf = SimplePpeProvider.getPacketPayloadEnumerator().enumeratePacketPayload(protocol, new MMOBuffer().setByteBuffer(body), sender);
		}
		catch (InvalidPacketOpcodeSchemeException | PartialPayloadEnumerationException e)
		{
			// do not interfere until definitions are fixed
			return;
		}
		final EnumeratedPayloadField field = buf.getSingleFieldIndex("antispam_fulltext_chat_msg");
		if (field == null)
			return;
		
		final String message = buf.readString(field);
		for (final Pattern p : _patterns)
		{
			if (!p.matcher(message).find())
				continue;
			
			packet.demandLoss(this);
			break;
		}
	}
	
	@Override
	public String getScriptName()
	{
		return "AntiSpam (SayPacket2)";
	}
	
	@Override
	public String getAuthor()
	{
		return "_dev_";
	}
	
	@Override
	public String getVersionString()
	{
		return "ALL";
	}
}
