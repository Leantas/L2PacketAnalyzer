/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.shortcut;

import net.l2emuproject.proxy.script.interpreter.ScriptedLegacyIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a type of a shortcut.
 * 
 * @author savormix
 */
public class ShortcutType extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "Item");
		addInterpretation(2, "Skill");
		addInterpretation(3, "Action");
		addInterpretation(4, "Macro");
		addInterpretation(5, "Recipe");
		addInterpretation(6, "Teleport bookmark");
	}
}
