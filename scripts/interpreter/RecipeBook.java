/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedBooleanInterpreter;

/**
 * Interprets the given boolean as a player recipe book's type.
 * 
 * @author savormix
 */
public final class RecipeBook extends ScriptedBooleanInterpreter
{
	/** Constructs this interpreter. */
	public RecipeBook()
	{
		super("Dwarven", "General/Common");
	}
}
