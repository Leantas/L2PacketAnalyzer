/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedZeroBasedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a character authorization dialog type.
 * 
 * @author savormix
 */
public class AuthDialog extends ScriptedZeroBasedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public AuthDialog()
	{
		super(new InterpreterMetadata("Error"), "Setup", "Input", "Closed");
	}
}
