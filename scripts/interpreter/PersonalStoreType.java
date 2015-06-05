/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedLegacyIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a type of a private store.
 * 
 * @author savormix
 */
public class PersonalStoreType extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "None");
		addInterpretation(1, "Seller"); // Private Store - Sell
		addInterpretation(2, "Managing sellables");
		addInterpretation(3, "Buyer"); // Private Store - Buy
		addInterpretation(4, "Managing buyables");
		addInterpretation(5, "Manufacturer");
		addInterpretation(6, "Managing manufacturables");
		addInterpretation(7, "Observing broadcast"); // Currently Watching a Game
		addInterpretation(8, "Package seller"); // Private Store - Package Sale
		addInterpretation(9, "Managing package sale");
	}
}
