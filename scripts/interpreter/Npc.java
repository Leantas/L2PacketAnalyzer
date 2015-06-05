/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedIntegerIdInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;
import net.l2emuproject.util.ImmutablePair;

/**
 * Interprets the given byte/word/dword as a NPC template ID.
 * 
 * @author savormix
 */
public class Npc extends ScriptedIntegerIdInterpreter
{
	private static final int NPC_CLASS_ID_OFFSET = 1_000_000;
	
	/** Constructs this interpreter. */
	public Npc()
	{
		super(loadFromResource("npc.txt", ImmutablePair.make_pair(0L, "None")));
	}
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		if (value >= NPC_CLASS_ID_OFFSET)
			value -= NPC_CLASS_ID_OFFSET;
		
		return super.getInterpretation(value, entityCacheContext);
	}
}
