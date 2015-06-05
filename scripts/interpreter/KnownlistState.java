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
 * Interprets an integer as one of a world object's existence states:
 * <UL>
 * <LI>Already present in the game world within user's knownlist range</LI>
 * <LI>Already reported to the user and within knownlist range</LI>
 * <LI>Currently being spawned within user's knownlist range</LI>
 * </UL>
 * 
 * @author _dev_
 */
public class KnownlistState extends ScriptedZeroBasedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public KnownlistState()
	{
		super("Existing world object", "Known object", "Newly spawned object");
	}
}
