/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.game.helper;

import util.packet.CommonPacketSender;
import util.packet.SystemMessageRecipient;
import eu.revengineer.simplejse.HasScriptDependencies;

import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.network.game.server.L2GameServer;
import net.l2emuproject.proxy.network.meta.RandomAccessMMOBuffer;
import net.l2emuproject.proxy.script.game.PpeEnabledGameScript;

/**
 * Notifies the user about their spoil skill usage success ON SCREEN.
 * 
 * @author _dev_
 */
@HasScriptDependencies({ "util.packet.CommonPacketSender", "util.packet.SystemMessageRecipient" })
public class SpoilSuccessNotifier extends PpeEnabledGameScript implements SystemMessageRecipient
{
	private static final int SM_ALREADY_SPOILED = 357;
	private static final int SM_SPOILED = 612;
	
	private static final int POS_SUCCESS = 2, POS_REDUNDANT = 7;
	private static final boolean SMALL_FONT = true, FADE = false;
	private static final int DURATION = 1_500;
	
	@Override
	public String getName()
	{
		return "Spoil success notifier";
	}
	
	@Override
	public void handleClientPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
	{
		// nothing to do here
	}
	
	@Override
	public void handleServerPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
	{
		final int message = buf.readFirstInteger32(SYSMSG_ID);
		switch (message)
		{
			case SM_SPOILED:
				CommonPacketSender.sendImmutableScreenSystemMessage(client, message, POS_SUCCESS, 0, SMALL_FONT, 0, 1, false, DURATION, FADE);
				break;
			case SM_ALREADY_SPOILED:
				CommonPacketSender.sendImmutableScreenSystemMessage(client, message, POS_REDUNDANT, 0, SMALL_FONT, 0, 1, false, DURATION, FADE);
				break;
			default:
				return;
		}
	}
}
