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
 * Interprets the given byte/word/dword as a result of an enchantment attempt.
 * 
 * @author savormix
 */
public class EnchantResult extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Successful enchant");
		addInterpretation(1, "Failed enchant: lost item, received crystals"); // prelude - no crystals received
		addInterpretation(2, "Inappriopriate conditions");
		addInterpretation(3, "Failed blessed enchant: retained item");
		addInterpretation(4, "Failed enchant: lost item");
		addInterpretation(5, "Failed safe enchant: retained enchant level");
	}
}
