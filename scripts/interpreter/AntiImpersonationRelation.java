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
 * Interprets the given byte/word/dword as known (high-level) relationships between two players.
 * 
 * @author _dev_
 */
public class AntiImpersonationRelation extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public AntiImpersonationRelation()
	{
		super("Friend", "Clan member", "Mentor/mentee", "Alliance member");
	}
}
