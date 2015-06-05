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
 * Interprets the second field mask byte of the ExNpcInfo/ExPetInfo/ExSummonInfo packet.
 * 
 * @author _dev_
 */
public class ExNpcInfoFieldMask2 extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public ExNpcInfoFieldMask2()
	{
		super(null, (Object)null, null, null, null, null, "Equipment", null);
	}
}
