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
 * Interprets the given byte/word/dword as an element type.
 * 
 * @author savormix
 */
public class ElementType extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(-2, "N/A");
		addInterpretation(-1, "None");
		addInterpretation(0, "Fire");
		addInterpretation(1, "Water");
		addInterpretation(2, "Wind");
		addInterpretation(3, "Earth");
		addInterpretation(4, "Holy");
		addInterpretation(5, "Dark");
	}
}
