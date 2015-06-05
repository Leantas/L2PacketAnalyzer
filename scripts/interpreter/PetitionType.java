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
 * Interprets the given byte/word/dword as a Castle Residence real estate.
 * 
 * @author Kamui
 */
public class PetitionType extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "Immobility");
		addInterpretation(2, "Recover Related");
		addInterpretation(3, "Bug Report");
		addInterpretation(4, "Quest Related");
		addInterpretation(5, "Report a Bad User");
		addInterpretation(6, "Suggestions");
		addInterpretation(7, "Game Tips");
		addInterpretation(8, "Operation Related");
		addInterpretation(9, "Other");
	}
}
