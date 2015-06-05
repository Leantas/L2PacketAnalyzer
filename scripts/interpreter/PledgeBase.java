/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedIntegerIdInterpreter;
import net.l2emuproject.util.ImmutablePair;

/**
 * Interprets the given byte/word/dword as a pledge's residence.
 * 
 * @author savormix
 */
public class PledgeBase extends ScriptedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public PledgeBase()
	{
		super(loadFromResource("pledgebase.txt", ImmutablePair.make_pair(0L, "None")));
	}
}
