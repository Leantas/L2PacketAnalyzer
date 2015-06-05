/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.game.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.mutable.MutableInt;

import util.packet.CommonPacketSender;

import eu.revengineer.simplejse.HasScriptDependencies;

import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.network.game.server.L2GameServer;
import net.l2emuproject.proxy.network.meta.RandomAccessMMOBuffer;
import net.l2emuproject.proxy.script.analytics.LiveUserAnalytics;
import net.l2emuproject.proxy.script.analytics.LiveUserAnalytics.UserInfo;
import net.l2emuproject.proxy.script.game.InteractiveChatCommands;
import net.l2emuproject.proxy.script.game.PpeEnabledGameScript;
import net.l2emuproject.proxy.script.packets.InvalidPacketWriterArgumentsException;
import net.l2emuproject.proxy.state.entity.cache.ObjectInfoCache;

/**
 * Helps visualizing polygon points as they are visited.
 * 
 * @author _dev_
 */
@HasScriptDependencies("util.packet.CommonPacketSender")
public class LocationMarker extends PpeEnabledGameScript implements InteractiveChatCommands
{
	private final Map<L2GameClient, MutableInt> _visibleItems;
	
	/** Constructs this interactive script. */
	public LocationMarker()
	{
		_visibleItems = new ConcurrentHashMap<>();
	}
	
	@Override
	public String getName()
	{
		return "Location marker";
	}
	
	@Override
	public void handleClientPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
	{
		final String msg = buf.readFirstString(CHAT_COMMAND);
		try
		{
			if ("\\\\loc_reset".equals(msg))
			{
				final MutableInt visibleItems = _visibleItems.remove(client);
				if (visibleItems == null)
				{
					CommonPacketSender.sendChatMessage(client, 5, "SYS", "No markers are visible.");
					return;
				}
				
				if (visibleItems.intValue() < 1)
					return;
				
				synchronized (visibleItems)
				{
					for (int oid = visibleItems.intValue(); oid > 0; --oid)
						CommonPacketSender.sendDeleteObject(client, oid, 0);
					visibleItems.setValue(0);
				}
				CommonPacketSender.sendChatMessage(client, 5, "SYS", "Location markers removed.");
				return;
			}
			
			if (!"\\\\loc".equals(msg))
				return;
			
			MutableInt maxOID = _visibleItems.get(client);
			if (maxOID == null)
			{
				final MutableInt tracker = new MutableInt();
				maxOID = _visibleItems.putIfAbsent(client, tracker);
				if (maxOID == null)
					maxOID = tracker;
			}
			
			final UserInfo ui = LiveUserAnalytics.getInstance().getUserInfo(client);
			synchronized (maxOID)
			{
				maxOID.add(1);
				CommonPacketSender.sendSpawnItem(client, maxOID.intValue(), 3434, ObjectInfoCache.getInstance().getOrAdd(ui.getUserOID(), getEntityContext(server)).getCurrentLocation(), false, 1L, 0);
			}
			CommonPacketSender.sendUserCmd(server, 0);
		}
		catch (InvalidPacketWriterArgumentsException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void handleServerPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
	{
		// do nothing here
	}
}
