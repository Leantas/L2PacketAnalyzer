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
 * Tests whether the value of a byte/word/dword is equal to 24.<BR>
 * <BR>
 * Used to check the type of chat in <TT>ChatMessage</TT>.
 * 
 * @author savormix
 */
public class MutableSM extends ScriptedIntegerEqualityCondition
{
	/** Constructs this interpreter. */
	public MutableSM()
	{
		super(24);
	}
}
