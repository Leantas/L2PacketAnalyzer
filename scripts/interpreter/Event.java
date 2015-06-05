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
 * Interprets the given byte/word/dword as an event type.
 * 
 * @author savormix
 */
public class Event extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(20090401, "April fool's 2009");
		addInterpretation(20090801, "Eva's inferno");
		addInterpretation(20091031, "Haloween 2009");
		addInterpretation(20091225, "Raising rudolph");
		addInterpretation(20100214, "Lover's jubilee");
		addInterpretation(20100401, "Player commendation");
	}
}
