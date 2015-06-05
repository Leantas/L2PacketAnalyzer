/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.status;

import net.l2emuproject.proxy.script.condition.ScriptedIntegerEqualityCondition;

/**
 * Tests whether the value of a byte/word/dword is equal to 33.<BR>
 * <BR>
 * Used to check the type of attribute in <TT>StatusUpdate</TT>.
 * 
 * @author savormix
 */
public class CurrentCp extends ScriptedIntegerEqualityCondition
{
	/** Constructs this interpreter. */
	public CurrentCp()
	{
		super(33);
	}
}
