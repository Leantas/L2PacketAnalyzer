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
 * Interprets the given byte/word/dword as a game server's name.
 * 
 * @author savormix
 */
public class GameServerName extends ScriptedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public GameServerName()
	{
		super(loadFromResource("server.txt", ImmutablePair.make_pair(0L, "None")));
	}
}
