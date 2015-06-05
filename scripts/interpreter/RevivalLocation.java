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
 * Interprets the given byte/word/dword as a default revival location type.
 * 
 * @author savormix
 */
public class RevivalLocation extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Town/Village");
		addInterpretation(1, "Hideout");
		addInterpretation(2, "Castle");
		addInterpretation(3, "Fortress");
		addInterpretation(4, "Headquarters");
		addInterpretation(5, "Fixed");
		addInterpretation(6, "Agathion??");
		addInterpretation(27, "Consultation area??");
	}
}
