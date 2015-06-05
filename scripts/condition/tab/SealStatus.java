/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.tab;

import net.l2emuproject.proxy.script.condition.ScriptedIntegerEqualityCondition;

/**
 * Tests whether the value of a byte/word/dword is equal to 3. <BR>
 * <BR>
 * Used to check the selected page in <TT>SevenSignsInfo</TT>.
 * 
 * @author savormix
 */
public class SealStatus extends ScriptedIntegerEqualityCondition
{
	/** Constructs this interpreter. */
	public SealStatus()
	{
		super(3);
	}
}
