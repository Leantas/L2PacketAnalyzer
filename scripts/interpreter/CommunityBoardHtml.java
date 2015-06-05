/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import eu.revengineer.simplejse.HasScriptDependencies;

import net.l2emuproject.lang.L2TextBuilder;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Used to preserve tags in L2 HTMLs.
 * 
 * @author savormix
 */
@HasScriptDependencies("interpreter.PreformattedHtml")
public class CommunityBoardHtml extends PreformattedHtml
{
	@Override
	public Object getInterpretation(String value, ICacheServerID entityCacheContext)
	{
		final L2TextBuilder tb = new L2TextBuilder();
		int contentIdx = 0;
		for (int idx = 0; (idx = value.indexOf(8, contentIdx) + 1) != 0; contentIdx = idx)
			tb.append('[').append(value.substring(contentIdx, idx)).append(']');
		return tb.append(super.getInterpretation(value.substring(contentIdx), entityCacheContext)).moveToString();
	}
}
