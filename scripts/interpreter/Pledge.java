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
import net.l2emuproject.proxy.state.entity.PledgeCrestInfo;
import net.l2emuproject.proxy.state.entity.PledgeInfo;
import net.l2emuproject.proxy.state.entity.cache.PledgeCrestInfoCache;
import net.l2emuproject.proxy.state.entity.cache.PledgeInfoCache;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword as a pledge ID.
 * 
 * @author savormix
 */
public class Pledge extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		final PledgeInfo pi = PledgeInfoCache.getInstance().getOrAdd((int)value, entityCacheContext);
		
		final L2TextBuilder sb = new L2TextBuilder();
		if (pi.getCrestID() != 0)
		{
			final PledgeCrestInfo pci = PledgeCrestInfoCache.getInstance().getOrAdd(pi.getCrestID(), entityCacheContext);
			if (pci.getCrest() != null)
				sb.append("<img src=\"").append(pci.getCrest()).append("\" border=\"0\" />");
		}
		sb.append(pi.getName());
		
		return sb.toString();
	}
}
