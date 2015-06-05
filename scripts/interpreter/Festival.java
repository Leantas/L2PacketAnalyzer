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
 * Interprets the given byte/word/dword as a Seven Signs festival division.
 * 
 * @author savormix
 */
public class Festival extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "Level 31 and below");
		addInterpretation(2, "Level 42 and below");
		addInterpretation(3, "Level 53 and below");
		addInterpretation(4, "Level 64 and below");
		addInterpretation(5, "No level limit");
	}
}
