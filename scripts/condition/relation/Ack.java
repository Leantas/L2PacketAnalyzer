/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.relation;

import net.l2emuproject.proxy.script.condition.ScriptedIntegerEqualityCondition;

/**
 * Tests for equality to 1.
 * 
 * @author _dev_
 */
public class Ack extends ScriptedIntegerEqualityCondition
{
	/** Constructs this interpreter. */
	public Ack()
	{
		super(1);
	}
}
