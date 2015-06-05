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
 * Interprets the given byte/word/dword as a subtype of <TT>RequestMessageRefusal</TT>.
 * 
 * @author savormix
 */
public class MessageRefusalAction extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Block player's chat");
		addInterpretation(1, "Allow player's chat");
		addInterpretation(2, "Show ignore list");
		addInterpretation(3, "Block all chat");
		addInterpretation(4, "Allow all chat");
	}
}
