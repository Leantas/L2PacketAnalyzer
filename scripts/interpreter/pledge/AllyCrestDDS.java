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
 * Properly adjusts the DDS height for a 8x12 px ally crest.
 * 
 * @author _dev_
 */
@HasScriptDependencies("interpreter.pledge.AbstractCrestDDS")
public class AllyCrestDDS extends AbstractCrestDDS
{
	/** Constructs this interpreter. */
	public AllyCrestDDS()
	{
		super(8, 12);
	}
	
	@Override
	public String getName()
	{
		return "Ally Crest 8x12 DDS";
	}
}
