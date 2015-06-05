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
 * Interprets the given byte/word/dword value as an uppercase ASCII letter. <BR>
 * <BR>
 * 'A' is represented by 0, 'B' is represented by 1, ... <BR>
 * <BR>
 * Used to interpret hair style/color and face selections.
 * 
 * @author savormix
 */
public class Alphabet extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		char c = (char)('A' + value);
		if (c < 'A' || c > 'Z')
			return value;
		
		return String.valueOf(c);
	}
}
