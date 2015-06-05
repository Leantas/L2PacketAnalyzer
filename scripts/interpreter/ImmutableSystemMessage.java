/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.l2emuproject.lang.L2TextBuilder;
import net.l2emuproject.proxy.script.interpreter.ScriptedIntegerIdInterpreter;
import net.l2emuproject.util.ImmutablePair;

/**
 * Interprets the given byte/word/dword as a system message.
 * 
 * @author savormix
 */
public class ImmutableSystemMessage extends ScriptedIntegerIdInterpreter
{
	private final Pattern[] _tokens;
	
	/** Constructs this interpreter. */
	public ImmutableSystemMessage()
	{
		super(loadFromResource("sm.txt", ImmutablePair.make_pair(-1L, "N/A")));
		_tokens = new Pattern[9];
		for (int i = 1; i <= 9; ++i)
			_tokens[i - 1] = Pattern.compile("\\$[cs]" + i);
	}
	
	/**
	 * Returns a system message with given tokens inserted into it.
	 * 
	 * @param sm system message ID
	 * @param tokens tokens
	 * @return complete message as string
	 */
	public String getRepresentation(int sm, String... tokens)
	{
		final L2TextBuilder tb = new L2TextBuilder(String.valueOf(getInterpretation(sm)));
		for (int i = 0; i < _tokens.length && i < tokens.length; ++i)
		{
			final Matcher m = _tokens[i].matcher(tb);
			if (!m.find())
				break;
			
			tb.replace(m.start(), m.end(), tokens[i]);
		}
		return tb.moveToString();
	}
}
