/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.pledge;

import eu.revengineer.simplejse.HasScriptDependencies;

/**
 * Properly adjusts the DDS height for a 16x12 px pledge crest.
 * 
 * @author _dev_
 */
@HasScriptDependencies("interpreter.pledge.AbstractCrestDDS")
public class PledgeCrestDDS extends AbstractCrestDDS
{
	/** Constructs this interpreter. */
	public PledgeCrestDDS()
	{
		super(16, 12);
	}
	
	@Override
	public String getName()
	{
		return "Pledge Crest 16x12 DDS";
	}
}
