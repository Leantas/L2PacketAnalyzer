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
 * Interprets the given byte/word/dword as a base item type.
 * 
 * @author savormix
 */
public class ItemType1 extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Weapon/Jewels"); // acc as well
		addInterpretation(1, "Armor/Shield");
		addInterpretation(4, "Adena/Quest item");
	}
}
