/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.party;

import net.l2emuproject.proxy.script.interpreter.ScriptedZeroBasedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as an affiliation with a player enlisted in party matching.
 * 
 * @author _dev_
 */
public class PartyMatchingAffilation extends ScriptedZeroBasedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public PartyMatchingAffilation()
	{
		super("No affilation", "Party member", "Party leader");
	}
}
