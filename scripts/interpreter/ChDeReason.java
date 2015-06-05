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
 * Interprets the given byte/word/dword as a reason why a character could not be deleted.
 * 
 * @author savormix
 */
public class ChDeReason extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "You have failed to delete the character.");
		addInterpretation(2, "You may not delete a clan member. Withdraw from the clan first and try again.");
		addInterpretation(3, "Clan leaders may not be deleted. Dissolve the clan first and try again.");
		addInterpretation(4, "You cannot delete characters on this server right now.");
	}
}
