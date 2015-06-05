/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.product;

import net.l2emuproject.proxy.network.meta.container.MetaclassRegistry;
import net.l2emuproject.proxy.network.meta.exception.InvalidFieldValueInterpreterException;
import net.l2emuproject.proxy.network.meta.interpreter.IntegerInterpreter;
import net.l2emuproject.proxy.network.meta.interpreter.impl.SecondsSinceEpoch;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * @author _dev_
 */
public class ProductMarketTime extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	private static final int PAST = 315558000, FUTURE = 2127452400;
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		if (value == PAST || value == FUTURE)
			return "N/A";
		try
		{
			return MetaclassRegistry.getInstance().getInterpreter(SecondsSinceEpoch.class.getSimpleName(), IntegerInterpreter.class).getInterpretation(value, entityCacheContext);
		}
		catch (InvalidFieldValueInterpreterException e)
		{
			// not possible for an internal class
			return value;
		}
	}
}
