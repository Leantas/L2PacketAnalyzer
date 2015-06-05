/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.quest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;

import net.l2emuproject.lang.L2TextBuilder;
import net.l2emuproject.proxy.network.meta.interpreter.ByteArrayInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;
import net.l2emuproject.proxy.ui.savormix.io.base.IOConstants;

/**
 * Interprets the given byte array as quest completion flags.
 * 
 * @author _dev_
 */
public class QuestCompletion extends ScriptedFieldValueInterpreter implements ByteArrayInterpreter, IOConstants
{
	private final String[] _questNames;
	
	/** Constructs this interpreter. */
	public QuestCompletion()
	{
		_questNames = new String[1024];
		for (int i = 0; i < _questNames.length; ++i)
			_questNames[i] = String.valueOf(i);
		try (final BufferedReader br = Files.newBufferedReader(INTERPRETER_CONFIG_DIRECTORY.resolve("quest.txt")))
		{
			for (String line; (line = br.readLine()) != null;)
			{
				final String[] quest = line.split("\t");
				int id = Integer.parseInt(quest[0]);
				if (id > 10_000)
					id -= 10_000;
				_questNames[id] = quest[1].intern();
			}
		}
		catch (IOException e)
		{
			// just use prefilled quest IDs
		}
	}
	
	@Override
	public Object getInterpretation(byte[] value, ICacheServerID entityCacheContext)
	{
		final L2TextBuilder tb = new L2TextBuilder();
		final int sz = Math.min(value.length, _questNames.length);
		for (int i = 0; i < sz; ++i)
		{
			for (int b = 0; b < 8; ++b)
			{
				if ((value[i] & (1 << b)) == 0)
					continue;
				
				tb.append('[').append(_questNames[(i << 3) | b]).append("], ");
			}
		}
		tb.setLength(tb.length() - 2);
		return tb.moveToString();
	}
}
