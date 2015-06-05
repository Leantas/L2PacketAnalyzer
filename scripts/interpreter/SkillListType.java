/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedLegacyIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a type of a skill list.
 * 
 * @author savormix
 */
public final class SkillListType extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(0, "Class");
		addInterpretation(1, "Fishing");
		addInterpretation(2, "Pledge");
		addInterpretation(3, "Unit");
		
		addInterpretation(5, "Certification");
		addInterpretation(6, "Collection");
	}
}
