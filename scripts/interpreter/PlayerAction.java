/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as an action request. <BR>
 * <BR>
 * These requests may affect either the player or their servitor.
 * 
 * @author savormix
 */
public class PlayerAction extends ScriptedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public PlayerAction()
	{
		super(loadFromResource("action.txt"));
	}
}
