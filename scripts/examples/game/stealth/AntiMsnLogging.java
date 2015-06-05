/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.game.stealth;

import net.l2emuproject.proxy.network.Packet;
import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.network.game.server.L2GameServer;
import net.l2emuproject.proxy.script.game.GameScript;

/**
 * A script that prevents MSN chat from being logged at the game server.<BR>
 * <BR>
 * The notification about logging will still be shown to you and your contact.
 * 
 * @author savormix
 */
public final class AntiMsnLogging extends GameScript
{
	private static final int REPORT_MSN_CHAT_MESSAGE = 109;
	
	/** Constructs this script. */
	public AntiMsnLogging()
	{
		super(new int[] { REPORT_MSN_CHAT_MESSAGE }, null);
	}
	
	@Override
	protected void clientPacketArrived(L2GameClient sender, L2GameServer recipient, Packet packet) throws IllegalStateException
	{
		//packet.demandLoss(this);
	}
	
	@Override
	public String getScriptName()
	{
		return "Anti-MSN Logging";
	}
	
	@Override
	public String getAuthor()
	{
		return "savormix";
	}
	
	@Override
	public String getVersionString()
	{
		return "All";
	}
}
