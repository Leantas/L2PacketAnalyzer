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
 * Interprets the given byte/word/dword as a GM view type.
 * 
 * @author savormix
 */
public class GmView extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "Info");
		addInterpretation(2, "Pledge");
		addInterpretation(3, "Skills");
		addInterpretation(4, "Active quests");
		addInterpretation(5, "Inventory");
		addInterpretation(6, "Warehouse");
	}
}
