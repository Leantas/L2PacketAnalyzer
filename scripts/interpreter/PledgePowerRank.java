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
 * Interprets the given byte/word/dword as a pledge authorization level.
 * 
 * @author savormix
 */
public class PledgePowerRank extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "1st level");
		addInterpretation(2, "2nd level");
		addInterpretation(3, "3rd level");
		addInterpretation(4, "4th level");
		addInterpretation(5, "5th level");
		addInterpretation(6, "Main clan");
		addInterpretation(7, "Royal guard");
		addInterpretation(8, "Order of knights");
		addInterpretation(9, "Academy");
	}
}
