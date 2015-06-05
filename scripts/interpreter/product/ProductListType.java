/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.product;

import net.l2emuproject.proxy.script.interpreter.ScriptedZeroBasedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a product list type.
 * 
 * @author _dev_
 */
public class ProductListType extends ScriptedZeroBasedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public ProductListType()
	{
		super("Store", "Purchase history", "Favorites");
	}
}
