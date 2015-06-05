/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.skill;

import net.l2emuproject.proxy.network.meta.interpreter.IntegerInterpreter;
import net.l2emuproject.proxy.script.interpreter.L2SkillTranslator;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * An interpreter compatible with both legacy skill levels and IO+ joint level+sublevel fields.
 * Take note, IO client does not expect 2 separate fields for skill level, but a single (joint) one.
 * 
 * @author _dev_
 */
public final class SkillLevel extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		final int level = L2SkillTranslator.getSkillLevel(value), sublevel = L2SkillTranslator.getSkillSublevel(value);
		if (sublevel == 0)
			return level;
		
		return level + ", sublevel: " + sublevel;
	}
}
