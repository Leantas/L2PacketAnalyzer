/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.lang.L2TextBuilder;
import net.l2emuproject.proxy.network.meta.interpreter.IntegerInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword value as a player commendation event session timer.
 * 
 * @author savormix
 */
public class PcTimer extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	private static final int FIVE_MINUTES = 100;
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		int minutes = (int)value / FIVE_MINUTES * 5;
		final int hours = minutes / 60;
		final L2TextBuilder tb = new L2TextBuilder();
		if (hours < 10)
			tb.append('0');
		tb.append(hours).append(':');
		minutes %= 60;
		if (minutes < 10)
			tb.append('0');
		tb.append(minutes);
		return tb.moveToString();
	}
}
