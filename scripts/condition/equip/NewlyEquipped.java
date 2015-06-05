/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.equip;

import net.l2emuproject.proxy.script.condition.ScriptedIntegerEqualityCondition;

/**
 * Tests whether the value of a byte/word/dword is equal to 1.<BR>
 * <BR>
 * Used to check the type of action in <TT>EquipUpdate</TT>.
 * 
 * @author _dev_
 */
public class NewlyEquipped extends ScriptedIntegerEqualityCondition
{
	/** Constructs this interpreter. */
	public NewlyEquipped()
	{
		super(1);
	}
}
