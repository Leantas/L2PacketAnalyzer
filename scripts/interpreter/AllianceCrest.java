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
import net.l2emuproject.proxy.state.entity.AllianceCrestInfo;
import net.l2emuproject.proxy.state.entity.cache.AllianceCrestInfoCache;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword as a pledge crest ID.
 * 
 * @author savormix
 */
public class AllianceCrest extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		final AllianceCrestInfo aci = AllianceCrestInfoCache.getInstance().getOrAdd((int)value, entityCacheContext);
		if (aci.getCrest() == null)
			return value;
		
		final StringBuilder sb = new StringBuilder();
		sb.append("<img src=\"").append(aci.getCrest()).append("\" border=\"0\" />");
		return sb.toString();
	}
}
