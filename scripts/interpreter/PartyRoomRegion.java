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
 * Interprets the given byte/word/dword as one of Aden's regions (this includes the Gracia continent).
 * 
 * @author savormix
 */
public class PartyRoomRegion extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(-1, "Any");
		addInterpretation(0, "Offline");
		addInterpretation(1, "Talking island");
		addInterpretation(2, "Gludio");
		addInterpretation(3, "Dark elven");
		addInterpretation(4, "Elven");
		addInterpretation(5, "Dion");
		addInterpretation(6, "Giran");
		addInterpretation(7, "Neutral zone");
		
		addInterpretation(9, "Schuttgart");
		addInterpretation(10, "Oren");
		addInterpretation(11, "Hunters village");
		addInterpretation(12, "Innadril");
		addInterpretation(13, "Aden");
		addInterpretation(14, "Rune");
		addInterpretation(15, "Goddard");
	}
}
