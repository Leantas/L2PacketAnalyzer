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
 * Interprets the given byte/word/dword as a warehouse usage result.<BR>
 * <BR>
 * Both excess weight and full inventory do not cause a WH usage packet to be sent.
 * 
 * @author savormix
 */
public class WarehouseUsageResult extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(-2, "Not enough adena");
		addInterpretation(-1, "Warehouse is full");
		addInterpretation(1, "Success");
	}
}
