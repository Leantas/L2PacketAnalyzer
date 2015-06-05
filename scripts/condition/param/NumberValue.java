/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.param;

import net.l2emuproject.proxy.network.meta.condition.IntegerCondition;
import net.l2emuproject.proxy.script.condition.ScriptedFieldValueCondition;

/**
 * Tests whether the value of a byte/word/dword is equal to 1 or 17.<BR>
 * <BR>
 * Used to check the type of parameter in <TT>SystemMessage</TT>.
 * 
 * @author savormix
 */
public class NumberValue extends ScriptedFieldValueCondition implements IntegerCondition
{
	public boolean test(long value)
	{
		return value == 1 || value == 17;
	}
}
