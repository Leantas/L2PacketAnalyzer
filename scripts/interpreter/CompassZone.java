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
 * Interprets the given byte/word/dword as a zone type displayed on (and shortly below) compass.
 * 
 * @author savormix
 */
public class CompassZone extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(8, "Altered");
		addInterpretation(9, "Altered");
		addInterpretation(11, "Siege war");
		addInterpretation(12, "Peaceful");
		addInterpretation(13, "Seven signs");
		addInterpretation(14, "PvP");
		addInterpretation(15, "General field");
	}
}
