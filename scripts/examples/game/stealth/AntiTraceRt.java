/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.game.stealth;

import java.nio.ByteBuffer;

import org.apache.commons.lang3.ArrayUtils;

import net.l2emuproject.network.ClientProtocolVersion;
import net.l2emuproject.proxy.network.Packet;
import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.network.game.server.L2GameServer;
import net.l2emuproject.proxy.script.game.GameScript;

/**
 * A script that automatically removes client's IP & hops sent in the <TT>RequestEnterWorld</TT> packet.<BR>
 * <BR>
 * By default, client sends a valid IP, but some hops may be 0.0.0.0. With this script, both the IP
 * and all hops are changed to 0.0.0.0.
 * 
 * @author savormix
 */
public final class AntiTraceRt extends GameScript
{
	private static final int REQUEST_ENTER_WORLD = 17;
	private static final byte[] NULL_IPS = new byte[20]; // prevent allocations
	
	/** Constructs this script. */
	public AntiTraceRt()
	{
		super(new int[] { REQUEST_ENTER_WORLD }, ArrayUtils.EMPTY_INT_ARRAY);
	}
	
	@Override
	protected void clientPacketArrived(L2GameClient sender, L2GameServer recipient, Packet packet)
	{
		if (recipient.getProtocol().isOlderThan(ClientProtocolVersion.GRACIA_FINAL))
			return;
		
		ByteBuffer newBody = packet.getDefaultBufferForModifications();
		newBody.position(85); // ignore opcode & whatever
		newBody.put(NULL_IPS);
		// ignore anything else
		packet.setForwardedBody(newBody);
	}
	
	@Override
	public String getScriptName()
	{
		return "Anti-tracert";
	}
	
	@Override
	public String getAuthor()
	{
		return "savormix";
	}
	
	@Override
	public String getVersionString()
	{
		return "GF and above";
	}
}
