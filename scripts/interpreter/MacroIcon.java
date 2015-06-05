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
 * Interprets the given byte/word/dword as a macro icon.
 * 
 * @author savormix
 */
public class MacroIcon extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Sword/Bolt");
		addInterpretation(1, "Wand/Bolt");
		addInterpretation(2, "Wand");
		addInterpretation(3, "Chat");
		addInterpretation(4, "Potion");
		addInterpretation(5, "Chest");
		addInterpretation(6, "Cycle");
		// TODO: update with new icons; perhaps use the icons themselves?
	}
}
