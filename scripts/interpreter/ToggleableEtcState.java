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
 * Interprets the toggleable etc state mask.
 * 
 * @author _dev_
 */
public class ToggleableEtcState extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public ToggleableEtcState()
	{
		super("Block All Chat", "Danger Area", "Charm of Courage");
	}
}
