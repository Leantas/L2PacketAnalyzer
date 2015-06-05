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
 * Interprets the given byte/word/dword as a pledge nobility rank.
 * 
 * @author savormix
 */
public class PledgeRank extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Vagabond");
		addInterpretation(1, "Vassal");
		addInterpretation(2, "Heir");
		addInterpretation(3, "Knight");
		addInterpretation(4, "Elder");
		addInterpretation(5, "Baron");
		addInterpretation(6, "Viscount");
		addInterpretation(7, "Count");
		addInterpretation(8, "Marquis");
		addInterpretation(9, "Duke");
		addInterpretation(10, "Grand Duke");
		addInterpretation(11, "Distinguished King");
	}
}
