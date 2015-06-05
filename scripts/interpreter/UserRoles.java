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
 * Interprets the given bitmask as user's possible social roles.
 * 
 * @author _dev_
 */
public final class UserRoles extends ScriptedBitmaskInterpreter
{
	public UserRoles()
	{
		// @formatter:off
		super("None", null,
				null, // 0
				"In PvP",
				"Chaotic",
				"In party",
				"Party leader",
				"In pledge", // 5
				"Pledge leader",
				null,
				null,
				null,
				"In alliance", // 10
				"Alliance leader");
		// @formatter:on
	}
}
