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
 * Interprets the given byte/word/dword as an updatable player's attribute.
 * 
 * @author savormix
 */
public class UpdatableAttribute extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "Level");
		addInterpretation(2, "XP");
		addInterpretation(3, "STR");
		addInterpretation(4, "DEX");
		addInterpretation(5, "CON");
		addInterpretation(6, "INT");
		addInterpretation(7, "WIT");
		addInterpretation(8, "MEN");
		addInterpretation(9, "Current HP");
		addInterpretation(10, "Maximum HP");
		addInterpretation(11, "Current MP");
		addInterpretation(12, "Maximum MP");
		addInterpretation(13, "SP");
		addInterpretation(14, "Current carried weight");
		addInterpretation(15, "Maximum carried weight");
		
		addInterpretation(17, "P. Atk.");
		addInterpretation(18, "Attack speed");
		addInterpretation(19, "P. Def.");
		addInterpretation(20, "Evasion");
		addInterpretation(21, "Accuracy");
		addInterpretation(22, "Critical");
		addInterpretation(23, "M. Atk.");
		addInterpretation(24, "Casting speed");
		addInterpretation(25, "M. Def.");
		addInterpretation(26, "In PvP");
		addInterpretation(27, "Karma");
		
		addInterpretation(33, "Current CP");
		addInterpretation(34, "Maximum CP");
	}
}
