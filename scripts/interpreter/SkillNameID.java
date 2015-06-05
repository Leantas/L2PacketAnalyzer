/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.l2emuproject.proxy.script.interpreter.L2SkillTranslator;
import net.l2emuproject.proxy.script.interpreter.ScriptedIntegerIdInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;
import net.l2emuproject.proxy.ui.savormix.io.base.IOConstants;
import net.l2emuproject.util.logging.L2Logger;

/**
 * Interprets the given byte/word/dword as a skill name ID.
 * 
 * @author savormix
 */
public class SkillNameID extends ScriptedIntegerIdInterpreter
{
	private static final L2Logger LOG = L2Logger.getLogger(SkillNameID.class);
	
	/** Constructs this interpreter. */
	public SkillNameID()
	{
		super(loadInterpretations());
	}
	
	private static final Map<Long, String> loadInterpretations()
	{
		final Map<Long, String> mapping = new HashMap<>();
		try (final BufferedReader br = IOConstants.openScriptResource("interpreter", "skill.txt"))
		{
			for (String line; (line = br.readLine()) != null;)
			{
				final int idx = line.indexOf('\t'), idx2 = line.indexOf('\t', idx + 1);
				if (idx == -1 || idx2 == -1)
					continue;
				
				final int id = Integer.parseInt(line.substring(0, idx));
				final int lvl = Integer.parseInt(line.substring(idx + 1, idx2));
				final String name = line.substring(idx2 + 1);
				
				mapping.put(Long.valueOf(L2SkillTranslator.getSkillNameID(id, lvl, null)), name.intern());
			}
		}
		catch (IOException e)
		{
			LOG.error("Could not load skill level interpretations", e);
		}
		mapping.put(Long.valueOf(L2SkillTranslator.getSkillNameID(0, 1, 0)), "None");
		return mapping;
	}
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		final Object result = super.getInterpretation(value, entityCacheContext);
		if (result instanceof String)
			return result;
		
		return L2SkillTranslator.getSkillID(value) + "_" + L2SkillTranslator.getSkillLevel(value) + "_" + L2SkillTranslator.getSkillSublevel(value);
	}
}
