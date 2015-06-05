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
 * Interprets the given byte/word/dword value as an monster race bet multiplier.<BR>
 * <BR>
 * Standard bet is 100 adena and is represented as 1.
 * 
 * @author savormix
 */
public class MonsterRaceBetMultiplier extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		return value * 100;
	}
}
