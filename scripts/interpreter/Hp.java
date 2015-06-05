/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.network.meta.interpreter.IntegerInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword value as some object's HP.
 * 
 * @author savormix
 */
public class Hp extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	// High Five specific
	private static final int PREDICTED_ABSOLUTE_HP_LIMIT = 99_999;
	private static final int EQUAL_TO_MAXIMUM_HP = 10_000_000;
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		if (value > PREDICTED_ABSOLUTE_HP_LIMIT)
			return String.valueOf(value * 100 / EQUAL_TO_MAXIMUM_HP) + "%";
		
		return value;
	}
}
