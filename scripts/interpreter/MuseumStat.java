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
 * Interprets the given byte/word/dword as a statistic of the museum.
 * 
 * @author savormix
 */
public class MuseumStat extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		// General
		addInterpretation(0, "Acquired XP");
		addInterpretation(1, "Acquired adena");
		addInterpretation(2, "Play duration");
		addInterpretation(3, "Battle duration");
		addInterpretation(4, "Party duration");
		addInterpretation(5, "Full party duration");
		addInterpretation(7, "N/A");
		addInterpretation(8, "N/A");
		addInterpretation(11, "Private store sales");
		addInterpretation(12, "Quest clear");
		addInterpretation(13, "Soulshot usage");
		addInterpretation(14, "Spiritshot usage");
		addInterpretation(15, "N/A (Max monster damage in one hit)");
		addInterpretation(16, "N/A (Most damage to monsters)");
		addInterpretation(17, "N/A (Most damage from monsters)");
		addInterpretation(18, "Number of resurrections (cast)");
		addInterpretation(19, "Number of resurrections (received)");
		addInterpretation(20, "Number of deaths");
		addInterpretation(21, "Weapon max enchant");
		addInterpretation(22, "Weapon enchant attempt");
		addInterpretation(23, "Armor enchant");
		addInterpretation(24, "Armor enchant attempt");
		// Hunting field
		addInterpretation(1000, "Number of monster killings");
		addInterpretation(1001, "Monster kill XP");
		addInterpretation(1002, "Number of deaths by monsters");
		addInterpretation(1003, "Max monster damage in one hit");
		addInterpretation(1004, "Most damage to monsters");
		addInterpretation(1005, "Most damage from monsters");
		addInterpretation(1006, "N/A (raided this week)");
		addInterpretation(1007, "N/A (raided ever)");
		// PVP
		addInterpretation(2000, "N/A");
		addInterpretation(2001, "PK defeat count");
		addInterpretation(2002, "PVP defeat count");
		addInterpretation(2003, "PVP victory count?");
		addInterpretation(2004, "PK victory count");
		addInterpretation(2005, "PVP victory count");
		addInterpretation(2006, "Max PvP damage in one hit");
		addInterpretation(2007, "Most damage done during PvP");
		addInterpretation(2008, "Most damage received during PvP");
		// Clan
		addInterpretation(3000, "Number clan members");
		addInterpretation(3001, "Number of people who entered");
		addInterpretation(3002, "Number of people who withdrew");
		addInterpretation(3003, "Fame");
		addInterpretation(3004, "Asset");
		addInterpretation(3005, "PVP count");
	}
}
