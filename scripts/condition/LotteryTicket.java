/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition;

import net.l2emuproject.proxy.script.condition.ScriptedIntegerEqualityCondition;

/**
 * Tests whether the value of a byte/word/dword is not equal to 4442.<BR>
 * <BR>
 * Used to check if an item is a lottery ticket.
 * 
 * @author savormix
 */
public class LotteryTicket extends ScriptedIntegerEqualityCondition
{
	/** Constructs this interpreter. */
	public LotteryTicket()
	{
		super(4442);
	}
}
