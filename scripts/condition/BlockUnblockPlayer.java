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
 * Tests whether the value of a byte/word/dword is less equal to either 0 or 1.<BR>
 * <BR>
 * Used to check the subtype of <TT>RequestMessageRefusal</TT>.
 * 
 * @author savormix
 */
public class BlockUnblockPlayer extends ScriptedFieldValueCondition implements IntegerCondition
{
	@Override
	public boolean test(long value)
	{
		return value == 0 || value == 1;
	}
}
