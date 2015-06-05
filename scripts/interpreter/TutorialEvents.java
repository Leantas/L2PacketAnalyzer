/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedBitmaskInterpreter;

/**
 * Interprets the given bit mask as tutorial events that server listens for from the client.
 * 
 * @author savormix
 */
public class TutorialEvents extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public TutorialEvents()
	{
		// missing: level79 level39 level75 level35 level20 level15 level7 level5
		// @formatter:off
		super("All notifications disabled", null,
				"move", // 0 | LMB click; moving with WASD will not cause client to send anything
				"view_change", // RMB + motion
				"wheel_scroll", // MW scroll
				"right_click", // RMB click
				"wheel_click", // MW/MMB click
				null, // 5
				null,
				null,
				"hp1_3", // Aside from the oldest clients, this is indicated by a flashing HP bar
				"die1_9 (1_4)",
				null, // 10
				null,
				null,
				"questtab", // ALT+U, then 'Item' tab
				null,
				null, // 15
				null,
				null,
				null,
				null,
				null, // 20
				null,
				null,
				"HP recovery" // Sitting/idling
		);
		// @formatter:on
	}
}
