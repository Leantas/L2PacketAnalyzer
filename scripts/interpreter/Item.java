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
 * Interprets the given byte/word/dword as an item ID.
 * 
 * @author savormix
 */
public class Item extends ScriptedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public Item()
	{
		// @formatter:off
		super(loadFromResource("item.txt",
				ImmutablePair.make_pair(0L, "None"),
				ImmutablePair.make_pair(-300L, "Fame"),
				ImmutablePair.make_pair(-500L, "Raid Points"),
				// the rest are missing in Valiance and later
				ImmutablePair.make_pair(-100L, "PC Cafe points"),
				ImmutablePair.make_pair(-200L, "Clan Reputation"),
				ImmutablePair.make_pair(-400L, "field_cycle_point_id3")
				));
		// @formatter:off
	}
}
