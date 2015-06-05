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
 * Interprets the given byte/word/dword as an element position on screen.
 * 
 * @author savormix
 */
public class ScreenMessagePosition extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Default");
		addInterpretation(1, "NW");
		addInterpretation(2, "N");
		addInterpretation(3, "NE");
		addInterpretation(4, "W");
		addInterpretation(5, "Center");
		addInterpretation(6, "E");
		addInterpretation(7, "S");
		addInterpretation(8, "SE");
	}
}
