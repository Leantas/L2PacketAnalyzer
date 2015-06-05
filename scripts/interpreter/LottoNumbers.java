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
 * Interprets two and a half bytes in a DWORD as selected lotto ticket numbers.
 * 
 * @author _dev_
 */
public class LottoNumbers extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public LottoNumbers()
	{
		super(generate());
	}
	
	private static final Object[] generate()
	{
		final String[] result = new String[20];
		for (int i = 0; i < result.length; ++i)
			result[i] = String.valueOf(i + 1);
		return result;
	}
}
