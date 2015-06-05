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
 * Interprets the given byte/word/dword as a customizable message field type.
 * 
 * @author savormix
 */
public class Parameter extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "String");
		addInterpretation(1, "Number");
		addInterpretation(2, "NPC");
		addInterpretation(3, "Item");
		addInterpretation(4, "Skill");
		addInterpretation(5, "Pledge base");
		addInterpretation(6, "Quantity");
		addInterpretation(7, "Zone");
		addInterpretation(8, "Item & Augmentation");
		addInterpretation(9, "Element");
		addInterpretation(10, "Instance");
		addInterpretation(11, "fstring (immutable)");
		addInterpretation(12, "Player");
		addInterpretation(13, "sysstring");
		addInterpretation(14, "fstring (mutable)");
		addInterpretation(15, "Class");
		addInterpretation(16, "Damage");
		addInterpretation(19, "Enchant level");
		addInterpretation(20, "Minute/second/recommendation amount");
		addInterpretation(21, "8 bit integer");
		addInterpretation(22, "16 bit integer");
	}
}
