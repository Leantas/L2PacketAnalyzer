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
 * Interprets the given byte/word/dword as a type of soulshot.
 * 
 * @author savormix
 */
public class SoulshotGrade extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(-1, "N/A");
		addInterpretation(0, "No grade");
		addInterpretation(1, "D grade");
		addInterpretation(2, "C grade");
		addInterpretation(3, "B grade");
		addInterpretation(4, "A grade");
		addInterpretation(5, "S grade");
		addInterpretation(6, "R grade");
	}
}
