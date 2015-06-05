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
 * Interprets the given byte/word/dword as a race ID.
 * 
 * @author savormix
 */
public class Race extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Human");
		addInterpretation(1, "Elf");
		addInterpretation(2, "Dark Elf");
		addInterpretation(3, "Orc");
		addInterpretation(4, "Dwarf");
		addInterpretation(5, "Kamael");
		addInterpretation(6, "Ertheia");
	}
}
