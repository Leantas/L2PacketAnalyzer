/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.login;

import org.apache.commons.lang3.ArrayUtils;

import net.l2emuproject.proxy.network.Packet;
import net.l2emuproject.proxy.network.login.client.L2LoginClient;
import net.l2emuproject.proxy.network.login.server.L2LoginServer;
import net.l2emuproject.proxy.network.login.server.packets.ServerList;
import net.l2emuproject.proxy.script.login.LoginScript;

/**
 * A script that automatically publishes the real server list in addition to the fake one.<BR>
 * <BR>
 * This script sends a fake notification about a forwarded packet. Use with care.<BR>
 * Personally, I think the real server list in UI/log is worth it, since 3rd party scripts shouldn't
 * be messing with the server list in the first place.
 * 
 * @author savormix
 */
public final class ServerListPublisher extends LoginScript
{
	/** Constructs this script. */
	public ServerListPublisher()
	{
		super(ArrayUtils.EMPTY_INT_ARRAY, new int[] { ServerList.OPCODE });
	}
	
	@Override
	protected void serverPacketArrived(L2LoginServer sender, L2LoginClient recipient, Packet packet)
	{
		// report the received packet
		sender.notifyPacketForwarded(null, packet.getReceivedBody(), packet.getReceptionTime());
	}
	
	@Override
	public String getScriptName()
	{
		return "Original ServerList in UI";
	}
	
	@Override
	public String getAuthor()
	{
		return "savormix";
	}
	
	@Override
	public String getVersionString()
	{
		return "All known versions";
	}
}
