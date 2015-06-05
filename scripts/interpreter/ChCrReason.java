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
 * Interprets the given byte/word/dword as a reason why a character could not be created.
 * 
 * @author savormix
 */
public class ChCrReason extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(-1, "Success");
		addInterpretation(0, "Your character creation has failed.");
		addInterpretation(1, "You cannot create another character. " + "Please delete the existing character and try again.");
		addInterpretation(2, "This name already exists.");
		addInterpretation(3, "Your title cannot exceed 16 characters in length. Please try again.");
		addInterpretation(4, "Incorrect name. Please try again.");
		addInterpretation(5, "Characters cannot be created from this server.");
		addInterpretation(6, "Unable to create character. " + "You are unable to create a new character on the selected server. " + "A restriction is in place which restricts users from creating "
				+ "characters on different servers where no previous character exists. " + "Please choose another server.");
	}
}
