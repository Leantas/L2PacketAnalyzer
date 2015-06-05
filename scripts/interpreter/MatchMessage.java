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
 * Interprets the given byte/word/dword as an event match message.
 * 
 * @author savormix
 */
public class MatchMessage extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "N/A");
		addInterpretation(1, "Finish");
		addInterpretation(2, "Start");
		addInterpretation(3, "Game over");
		addInterpretation(4, "1");
		addInterpretation(5, "2");
		addInterpretation(6, "3");
		addInterpretation(7, "4");
		addInterpretation(8, "5");
	}
}
