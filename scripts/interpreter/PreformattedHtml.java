/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.network.meta.interpreter.StringInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Used to preserve tags in L2 HTMLs (including truncated HTMLs, like Community Board ones).
 * 
 * @author savormix
 */
public class PreformattedHtml extends ScriptedFieldValueInterpreter implements StringInterpreter
{
	@Override
	public Object getInterpretation(String value, ICacheServerID entityCacheContext)
	{
		if (value.startsWith(".."))
			return value;
		
		return value.replace("<", "&lt;").replace(">", "&gt;");
	}
}
