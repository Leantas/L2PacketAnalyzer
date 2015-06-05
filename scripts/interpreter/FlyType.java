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
 * Interprets the given byte/word/dword as a type of flight.
 * 
 * @author savormix
 */
public class FlyType extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Vertical Throw");
		addInterpretation(1, "Horizontal Throw");
		addInterpretation(3, "Charge");
		addInterpretation(4, "Knockback");
		addInterpretation(5, "Vertical Hold");
		addInterpretation(6, "Not Used");
		addInterpretation(7, "Knockdown");
		addInterpretation(8, "Warp Backward");
		addInterpretation(9, "Warp Forward");
	}
}
