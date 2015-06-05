/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.status;

import net.l2emuproject.proxy.network.meta.condition.IntegerCondition;
import net.l2emuproject.proxy.script.condition.ScriptedFieldValueCondition;

/**
 * Tests whether the value of a byte/word/dword is not equal to neither 9 nor 10 nor 33.<BR>
 * <BR>
 * Used to check the type of attribute in <TT>StatusUpdate</TT>.
 * 
 * @author savormix
 */
public class DefaultAttribute extends ScriptedFieldValueCondition implements IntegerCondition
{
	@Override
	public boolean test(long value)
	{
		return value != 9 && value != 10 && value != 33;
	}
}
