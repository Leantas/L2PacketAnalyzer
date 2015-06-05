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
 * Interprets the given byte/word/dword as a Seven Signs cabal.
 * 
 * @author savormix
 */
public class MercenaryName extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "N/A");
		addInterpretation(81, "Gludio Guardian");
		addInterpretation(82, "Dion Guardian");
		addInterpretation(83, "Giran Guardian");
		addInterpretation(84, "Oren Guardian");
		addInterpretation(85, "Aden Guardian");
		addInterpretation(86, "Innadril Guardian");
		addInterpretation(87, "Goddard Guardian");
		addInterpretation(88, "Rune Guardian");
		addInterpretation(89, "Schuttgart Guardian");
	}
}
