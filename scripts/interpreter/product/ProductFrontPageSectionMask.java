/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.product;

import net.l2emuproject.proxy.script.interpreter.ScriptedBitmaskInterpreter;

/**
 * @author _dev_
 */
public class ProductFrontPageSectionMask extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public ProductFrontPageSectionMask()
	{
		super("Not on front page", null, "Featured", "Recommended", "Popular");
	}
}
