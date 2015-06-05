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
 * Interprets the given bit mask as game server's types.
 * 
 * @author savormix
 */
public class GameServerTypes extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public GameServerTypes()
	{
		super("Normal", "Relax", "Test", "Nameless", "Legacy (only existing characters)", "Event", "Free");
	}
}
