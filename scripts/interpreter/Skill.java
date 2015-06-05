/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import java.util.List;

import eu.revengineer.simplejse.HasScriptDependencies;
import eu.revengineer.simplejse.init.InitializationPriority;

import net.l2emuproject.proxy.network.meta.EnumeratedPayloadField;
import net.l2emuproject.proxy.network.meta.RandomAccessMMOBuffer;
import net.l2emuproject.proxy.network.meta.container.MetaclassRegistry;
import net.l2emuproject.proxy.network.meta.exception.InvalidFieldValueInterpreterException;
import net.l2emuproject.proxy.network.meta.interpreter.ContextualFieldValueInterpreter;
import net.l2emuproject.proxy.network.meta.interpreter.IntegerInterpreter;
import net.l2emuproject.proxy.script.ScriptedMetaclass;
import net.l2emuproject.proxy.script.interpreter.L2SkillTranslator;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword as a skill ID.
 * 
 * @author savormix
 */
@HasScriptDependencies("interpreter.SkillNameID")
@InitializationPriority(1)
public class Skill extends ScriptedFieldValueInterpreter implements ContextualFieldValueInterpreter, IntegerInterpreter
{
	private final ThreadLocal<Integer> _level;
	
	/** Constructs this interpreter. */
	public Skill()
	{
		_level = new ThreadLocal<Integer>()
		{
			@Override
			protected Integer initialValue()
			{
				return 1;
			}
		};
	}
	
	@Override
	public void reviewContext(RandomAccessMMOBuffer buf)
	{
		final List<EnumeratedPayloadField> skillIDs = buf.getFieldIndices("__INTERP_CORRECTION_SKILL_ID"), lvls = buf.getFieldIndices("__INTERP_CORRECTION_SKILL_LEVEL");
		for (int i = 0; i < skillIDs.size(); ++i)
		{
			if (skillIDs.get(i).getOffset() != buf.getCurrentOffset())
				continue;
			
			_level.set(buf.readInteger32(lvls.get(i)));
			return;
		}
		
		// no level supplied, default to first level (no sublevel)
		_level.set(1);
	}
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		final int id = (int)value, lvl = _level.get();
		value = L2SkillTranslator.getSkillNameID(id, lvl, null);
		try
		{
			final SkillNameID interpreter = MetaclassRegistry.getInstance().getInterpreter(ScriptedMetaclass.getAlias(SkillNameID.class), SkillNameID.class);
			return interpreter.getInterpretation(value, entityCacheContext);
		}
		catch (InvalidFieldValueInterpreterException e)
		{
			return id + "_" + L2SkillTranslator.getSkillLevel(lvl) + "_" + L2SkillTranslator.getSkillSublevel(lvl);
		}
		finally
		{
			_level.set(1);
		}
	}
}
