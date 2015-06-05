/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.museum;

import net.l2emuproject.proxy.network.meta.condition.IntegerCondition;
import net.l2emuproject.proxy.network.meta.container.MetaclassRegistry;
import net.l2emuproject.proxy.network.meta.exception.InvalidFieldValueConditionException;
import net.l2emuproject.proxy.script.condition.ScriptedFieldValueCondition;

import eu.revengineer.simplejse.HasScriptDependencies;

/**
 * Tests whether the value of a byte/word/dword is not equal to specific statistics.<BR>
 * <BR>
 * Used to check the type of statistic in <TT>MyMuseumRecord</TT> and <TT>TO_BE_NAMED</TT>.
 * 
 * @author savormix
 */
@HasScriptDependencies({ "condition.museum.AwakenedClass", "condition.museum.Grade", "condition.museum.Npc" })
public class DefaultStat extends ScriptedFieldValueCondition implements IntegerCondition
{
	private static final String[] DELEGATES = { "musem.Grade", "museum.Npc", "museum.AwakenedClass" };
	
	@Override
	public boolean test(long value)
	{
		for (final String s : DELEGATES)
		{
			try
			{
				if (MetaclassRegistry.getInstance().getCondition(s, IntegerCondition.class).test(value))
					return false;
			}
			catch (InvalidFieldValueConditionException e)
			{
				continue;
			}
		}
		return true;
	}
}
