/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package util.packet;

import net.l2emuproject.network.ClientProtocolVersion;
import net.l2emuproject.network.IGameProtocolVersion;
import net.l2emuproject.network.mmocore.MMOBuffer;
import net.l2emuproject.proxy.script.ScriptFieldAlias;

/**
 * Provides access to system message packets and related convenience methods.
 * 
 * @author _dev_
 */
public interface SystemMessageRecipient
{
	/** This is the system message ID integer */
	@ScriptFieldAlias
	String SYSMSG_ID = "SYS_MESSAGE_ID";
	/** This is the system message token type integer */
	@ScriptFieldAlias
	String SYSMSG_TOKENS = "SYS_MESSAGE_PARAMS";
	
	/** Indicates a string token. */
	int SYSMSG_TOKEN_STRING = 0;
	/** Indicates a NPC template token. */
	int SYSMSG_TOKEN_NPC = 2;
	/** Indicates a skill [level] template token. */
	int SYSMSG_TOKEN_SKILL = 4;
	/** Indicates a player name token. */
	int SYSMSG_TOKEN_PLAYER = 12;
	
	/**
	 * Reads the NPC template ID from the given buffer.
	 * 
	 * @param protocol network protocol version
	 * @param buf buffer wrapper
	 * @return NPC template ID
	 */
	static int getSysMsgNPCID(IGameProtocolVersion protocol, MMOBuffer buf)
	{
		return buf.readD();
	}
	
	/**
	 * Reads the skill template ID (skill ID and skill level) from the given buffer.
	 * 
	 * @param protocol network protocol version
	 * @param buf buffer wrapper
	 * @return skill template ID
	 */
	static long getSysMsgSkillNameID(IGameProtocolVersion protocol, MMOBuffer buf)
	{
		final long result = (long)buf.readD() << 32;
		final int level;
		if (protocol.isOlderThan(ClientProtocolVersion.ERTHEIA) || protocol.isNewerThanOrEqualTo(ClientProtocolVersion.INFINITE_ODYSSEY))
			level = buf.readD();
		else
			level = buf.readH();
		return result | level;
	}
}
