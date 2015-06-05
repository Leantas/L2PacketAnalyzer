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
 * Interprets the given byte/word/dword as vitality points and translates it to vitality level.
 * This is the pre-GoD scheme.
 * 
 * @author savormix
 */
public class VitalityLevel extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		if (value < 240)
			return "Level 0";
		else if (value < 1800)
			return "Level 1";
		else if (value < 13000)
			return "Level 2";
		else if (value < 17000)
			return "Level 3";
		else
			return "Level 4";
	}
}
