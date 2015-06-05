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
 * Interprets the given byte/word/dword as a skill's mana consumption type.
 * 
 * @author savormix
 */
public class ManaConsumptionType extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Physical");
		addInterpretation(1, "Magical");
		addInterpretation(2, "Song/dance"); // not even Rhythm of Start Dark causes this in Ertheia
		addInterpretation(3, "Enchant");
	}
}
