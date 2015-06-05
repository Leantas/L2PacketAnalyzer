/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedBitmaskInterpreter;

/**
 * Interprets the given byte/word/dword as a mask of elemental attributes.
 * 
 * @author _dev_
 */
public class ElementMask extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public ElementMask()
	{
		super("Fire", "Water", "Wind", "Earth", "Holy", "Dark");
	}
}
