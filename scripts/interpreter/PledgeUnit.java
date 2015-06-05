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
 * Interprets the given byte/word/dword as a subpledge.
 * 
 * @author savormix
 */
public class PledgeUnit extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(-1, "Academy");
		addInterpretation(0, "Pledge");
		addInterpretation(100, "Royal Guard A");
		addInterpretation(200, "Royal Guard B");
		addInterpretation(1001, "Order of Knights A-1");
		addInterpretation(1002, "Order of Knights A-2");
		addInterpretation(2001, "Order of Knights B-1");
		addInterpretation(2002, "Order of Knights B-2");
	}
}
