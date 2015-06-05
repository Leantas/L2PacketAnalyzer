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
 * Interprets the given boolean as a desired board window state (open/closed).
 * 
 * @author savormix
 */
public final class BoardWindow extends ScriptedBooleanInterpreter
{
	/** Constructs this interpreter. */
	public BoardWindow()
	{
		super("Close", "Open");
	}
}
