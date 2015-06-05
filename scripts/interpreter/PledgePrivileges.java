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
 * Interprets the given bit mask as required/used paperdoll slots.
 * 
 * @author savormix
 */
public class PledgePrivileges extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public PledgePrivileges()
	{
		// @formatter:off
		super(
				null,
				"Invite",
				"Manage titles",
				"Warehouse search",
				"Manage ranks",
				"Clan war", // 5
				"Dismiss",
				"Edit crest",
				"Apprentice",
				"Troops/Fame",
				"Summon airship", // 10
				"Clan hall: entry/exit",
				"Clan hall: use functions",
				"Clan hall: auction",
				"Clan hall: dismiss",
				"Clan hall: set functions", // 15
				"Castle/Fortress: entry/exit",
				"Castle/Fortress: manor admin",
				"Castle/Fortress: siege war",
				"Castle/Fortress: use functions",
				"Castle/Fortress: right to dismiss", // 20
				"Castle/Fortress: manage taxes",
				"Castle/Fortress: mercenaries",
				"Castle/Fortress: set functions"
		);
		// @formatter:on
	}
}
