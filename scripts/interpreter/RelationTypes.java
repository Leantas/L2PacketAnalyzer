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
 * Interprets the given bit mask as possible relationships between the user and other players.
 * This class was designed for C1.
 * 
 * @author savormix
 */
public class RelationTypes extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public RelationTypes()
	{
		// @formatter:off
		super("None", null,
				null, // 0
				"In PvP",
				"Chaotic",
				"In party",
				"Party leader",
				"Same party", // 5
				"In pledge",
				"Pledge leader",
				"Same pledge",
				null,
				null, // 10
				null,
				null,
				null,
				null,
				null, // 15
				null,
				"In alliance",
				"Alliance leader",
				"Same alliance");
		// @formatter:on
	}
	
	/* Needs complete review
	@Override
	protected String getZeroInterpretation()
	{
		return "Neutral";
	}
	
	@Override
	protected void loadImpl()
	{
		addInterpretation(4, "Party leader");
		addInterpretation(5, "Has party");
		addInterpretation(6, "Has pledge");
		addInterpretation(7, "Pledge leader");
		addInterpretation(8, "Pledge member");
		addInterpretation(9, "In siege??");
		addInterpretation(10, "Siege attacker??");
		addInterpretation(11, "Ally??");
		addInterpretation(12, "Enemy??");
		addInterpretation(13, "Mutual clan war");
		addInterpretation(14, "Non-mutual clan war");
		addInterpretation(15, "Has alliance");
		addInterpretation(16, "Mercenary");
	}
	
	/*
	@Override
	public String convert(int value)
	{
		StringBuilder sb = new StringBuilder();
		
		int party = value & 15; // party member no
		if (party > 0)
		{
			sb.append("Party member (");
			sb.append(10 - party);
			sb.append(')');
		}
		
		String result = super.convert(value);
		if (!getZeroInterpretation().equals(result))
		{
			sb.append(", ");
			sb.append(result.toLowerCase());
		}
		
		return sb.toString();
	}
	 */
}
