/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition;

import net.l2emuproject.proxy.network.meta.condition.IntegerCondition;
import net.l2emuproject.proxy.script.condition.ScriptedFieldValueCondition;

/**
 * Tests whether the value of a byte/word/dword is not equal to 4442, 4443 nor 4444.<BR>
 * <BR>
 * Used to check if an item is a normal item.
 * 
 * @author savormix
 */
public class GenericItem extends ScriptedFieldValueCondition implements IntegerCondition
{
	@Override
	public boolean test(long value)
	{
		return value < 4442 || value > 4444;
	}
}
