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
 * Interprets the given byte/word/dword as the main item type.
 * 
 * @author savormix
 */
public class ItemType2 extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(-1, "PC points/Pledge reputation/Fame");
		addInterpretation(0, "Weapon");
		addInterpretation(1, "Armor/Shield/Hat/Mask");
		addInterpretation(2, "Jewels/Bracelet/Talisman");
		addInterpretation(3, "Quest item");
		addInterpretation(4, "Adena");
		addInterpretation(5, "Other");
	}
}
