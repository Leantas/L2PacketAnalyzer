/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.structure;

import net.l2emuproject.proxy.script.interpreter.ScriptedBitmaskInterpreter;

/**
 * Interprets the fifth field mask byte of the ExNpcInfo/ExPetInfo/ExSummonInfo packet.
 * 
 * @author _dev_
 */
public class ExNpcInfoFieldMask5 extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public ExNpcInfoFieldMask5()
	{
		super(null, (Object)null, "AVE", "State flags", "Pledge/alliance", "Reputation", "PvP", "Title (fstring)");
	}
}
