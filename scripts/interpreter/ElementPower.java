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
 * Interprets the given byte/word/dword as an elemental power value and translates it to elemental
 * level.
 * 
 * @author savormix
 * @deprecated Should only be used for weapon elemental power.
 */
@Deprecated
public class ElementPower extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		if (value < 1)
			return "None";
		else if (value < 25)
			return "Level 1";
		else if (value < 75)
			return "Level 2";
		else if (value < 150)
			return "Level 3";
		else if (value < 175)
			return "Level 4";
		else if (value < 225)
			return "Level 5";
		else if (value < 300)
			return "Level 6";
		else if (value < 325)
			return "Level 7";
		else if (value < 375)
			return "Level 8";
		else if (value < 450)
			return "Level 9";
		else if (value < 475)
			return "Level 10";
		else if (value < 525)
			return "Level 11";
		else if (value < 600)
			return "Level 12";
		else
			return "Level 13";
	}
}
