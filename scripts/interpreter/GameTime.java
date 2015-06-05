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
 * Interprets the given byte/word/dword as in-game time (in-game minute count since server restart).
 * 
 * @author savormix
 */
public class GameTime extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		final int igHoursSinceStart = (int)value / 60;
		final int igHours = igHoursSinceStart % 24;
		final int igMinutes = (int)value % 60;
		
		final L2TextBuilder sb = new L2TextBuilder();
		if (igHours < 10)
			sb.append('0');
		sb.append(igHours).append(':');
		if (igMinutes < 10)
			sb.append('0');
		sb.append(igMinutes).append(" [Day ").append((igHoursSinceStart / 24) + 1).append(']');
		return sb.moveToString();
	}
}
