/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.pledge;

import net.l2emuproject.proxy.script.interpreter.ScriptedZeroBasedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword value as a pledge status.
 * 
 * @author _dev_
 */
public final class PledgeStatus extends ScriptedZeroBasedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public PledgeStatus()
	{
		super("Normal", null, null, "Pending dissolution"); // Dispersion has been requested
	}
}
