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
 * Interprets the given byte/word/dword as a cubic ID.
 * 
 * @author savormix
 */
public class Cubic extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "Storm");
		addInterpretation(2, "Vampiric");
		addInterpretation(3, "Life");
		addInterpretation(4, "Viper");
		addInterpretation(5, "Phantom");
		addInterpretation(6, "Binding");
		addInterpretation(7, "Aqua");
		addInterpretation(8, "Spark");
		addInterpretation(9, "Attractive");
		addInterpretation(10, "Smart (Eva's Templar)");
		addInterpretation(11, "Smart (Shilien Templar)");
		addInterpretation(12, "Smart (Arcana Lord)");
		addInterpretation(13, "Smart (Elemental Master)");
		addInterpretation(14, "Smart (Spectral Master)");
		addInterpretation(15, "Knight");
		addInterpretation(16, "Avenging");
		addInterpretation(17, "Fairy of Life");
		addInterpretation(18, "Buff");
		addInterpretation(19, "Mind");
		addInterpretation(20, "Phantom");
		addInterpretation(21, "Hex");
		addInterpretation(22, "Ertheia");
	}
}
