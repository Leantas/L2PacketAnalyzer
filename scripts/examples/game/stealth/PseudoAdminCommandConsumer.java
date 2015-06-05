/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.game.stealth;

import static net.l2emuproject.network.ClientProtocolVersion.THE_KAMAEL;

import java.nio.ByteBuffer;

import net.l2emuproject.network.mmocore.MMOBuffer;
import net.l2emuproject.proxy.network.Packet;
import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.network.game.server.L2GameServer;
import net.l2emuproject.proxy.script.game.GameScript;

/**
 * Consumes bypasses and chat messages of a specific format (as NetPro handles them asynchronously).
 * 
 * @author _dev_
 */
public class PseudoAdminCommandConsumer extends GameScript
{
	private static final int REQ_BYPASS = 0x23, REQ_BYPASS_LEGACY = 0x21;
	private static final int REQ_SAY2 = 0x49, REQ_SAY2_LEGACY = 0x38;
	private static final int REQ_TUTORIAL_CMD = 0x86, REQ_TUTORIAL_CMD_LEGACY = 0x7C;
	
	/** Constructs this script. */
	public PseudoAdminCommandConsumer()
	{
		super(new int[] { REQ_BYPASS_LEGACY, REQ_BYPASS, REQ_SAY2_LEGACY, REQ_SAY2, REQ_TUTORIAL_CMD_LEGACY, REQ_TUTORIAL_CMD }, null);
	}
	
	@Override
	protected void clientPacketArrived(L2GameClient sender, L2GameServer recipient, Packet packet) throws RuntimeException
	{
		final boolean legacy = sender.getProtocol().isOlderThan(THE_KAMAEL);
		switch (packet.getReceivedBody().get(0))
		{
			case REQ_BYPASS_LEGACY:
			case REQ_SAY2_LEGACY:
			case REQ_TUTORIAL_CMD_LEGACY:
				if (!legacy)
					return;
				break;
			default:
				if (legacy)
					return;
				break;
		}
		
		final ByteBuffer original = packet.getReceivedBody();
		if (original == null) // injected
			return;
		
		original.position(1); // skip single opcode
		final MMOBuffer buf = new MMOBuffer();
		buf.setByteBuffer(original);
		
		final String cmd = buf.readS();
		// double-backslash prefix for chat messages, __l2emu for normal/tutorial bypasses
		if (cmd.startsWith("\\\\") || cmd.startsWith("__l2emu"))
			packet.demandLoss(this);
	}
	
	@Override
	public String getScriptName()
	{
		return "Pseudo-Admin Async Enabler";
	}
	
	@Override
	public String getAuthor()
	{
		return "_dev_";
	}
	
	@Override
	public String getVersionString()
	{
		return "All";
	}
}
