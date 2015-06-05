/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a recipe ID.
 * 
 * @author savormix
 */
public class Recipe extends ScriptedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public Recipe()
	{
		super(loadFromResource("make.txt"));
	}
}
