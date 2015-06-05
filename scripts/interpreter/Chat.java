/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedLegacyIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a chat channel ID.
 * 
 * @author savormix
 */
public class Chat extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Local");
		addInterpretation(1, "Shout");
		addInterpretation(2, "PM");
		addInterpretation(3, "Party");
		addInterpretation(4, "Clan");
		addInterpretation(5, "SYS/GM (local)");
		addInterpretation(6, "Petitioner");
		addInterpretation(7, "Consultant");
		addInterpretation(8, "Trade");
		addInterpretation(9, "Alliance");
		addInterpretation(10, "Announcement");
		addInterpretation(11, "Ferry shout");
		addInterpretation(12, "Friend");
		addInterpretation(13, "MSN");
		addInterpretation(14, "Party room");
		addInterpretation(15, "Party commander");
		addInterpretation(16, "Party channel");
		addInterpretation(17, "Hero");
		addInterpretation(18, "Critical announcement");
		addInterpretation(19, "Screen announcement");
		addInterpretation(20, "Territory");
		addInterpretation(21, "Multi-party chat channel");
		addInterpretation(22, "NPC local");
		addInterpretation(23, "NPC shout");
		addInterpretation(24, "GM Chat");
		addInterpretation(25, "World");
	}
}
