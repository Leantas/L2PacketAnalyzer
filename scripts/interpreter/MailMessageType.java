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
 * @author _dev_
 */
public class MailMessageType extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		// Regular mail
		addInterpretation(0, "Standard");
		addInterpretation(1, "Private/noreply"); // sender name is '****' and reply/return buttons are removed
		addInterpretation(2, "Private"); // sender name is 'None'
		addInterpretation(3, "Anniversary"); // sender name is 'Alegria' and reply/return buttons are removed
		addInterpretation(4, "Hidden"); // all fields are empty and all buttons (except contact list) are removed
		addInterpretation(5, "Invisible"); // dialog window does not open
		addInterpretation(6, "Mentorship rewards"); // sender name is 'Mentor Guide' and reply/return buttons are removed
		// Other types
		addInterpretation(7, "Gift mailbox");
		addInterpretation(9, "Contact list prohibited"); // Contact list button is disabled
	}
}
