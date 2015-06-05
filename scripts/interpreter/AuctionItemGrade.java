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
 * Interprets the given byte/word/dword as an item grade.
 * 
 * @author savormix
 */
public class AuctionItemGrade extends ScriptedZeroBasedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public AuctionItemGrade()
	{
		// @formatter:off
		super(new InterpreterMetadata(-1),
				"All",
				"No grade", // 0
				"D grade",
				"C grade",
				"B grade",
				"A grade",
				"S grade", // 5
				"S80 grade",
				"S84 grade (N/A)",
				"R grade",
				"R95 grade",
				"R99 grade" // 10
		);
		// @formatter:on
	}
}
