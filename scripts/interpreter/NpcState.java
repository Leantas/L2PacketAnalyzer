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
 * I don't know much about this, so I cannot comment.
 * 
 * @author savormix
 */
public class NpcState extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public NpcState()
	{
		super("In combat", "Lying dead", "Targetable", "Show name tag");
	}
}