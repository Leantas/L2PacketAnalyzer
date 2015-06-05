/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import java.util.Map;
import java.util.Map.Entry;

import eu.revengineer.simplejse.HasScriptDependencies;
import eu.revengineer.simplejse.init.InitializationPriority;

import net.l2emuproject.proxy.network.meta.container.MetaclassRegistry;
import net.l2emuproject.proxy.network.meta.exception.InvalidFieldValueInterpreterException;
import net.l2emuproject.proxy.script.ScriptedMetaclass;
import net.l2emuproject.proxy.script.interpreter.ScriptedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a transformation ID.
 * 
 * @author savormix
 */
@HasScriptDependencies("interpreter.Npc")
@InitializationPriority(1)
public class Transformation extends ScriptedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public Transformation()
	{
		super(convertToNPCs(loadFromResource("trans.txt")));
	}
	
	private static final Map<Long, String> convertToNPCs(Map<Long, String> transformations)
	{
		try
		{
			final Npc interpreter = MetaclassRegistry.getInstance().getInterpreter(ScriptedMetaclass.getAlias(Npc.class), Npc.class);
			for (final Entry<Long, String> e : transformations.entrySet())
				e.setValue(String.valueOf(interpreter.getInterpretation(Long.parseLong(e.getValue()))));
		}
		catch (InvalidFieldValueInterpreterException e)
		{
			// the NPC interpreter might be disabled
		}
		transformations.put(0L, "None");
		return transformations;
	}
}
