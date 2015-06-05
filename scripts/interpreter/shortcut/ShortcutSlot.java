/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.shortcut;

import net.l2emuproject.lang.L2TextBuilder;
import net.l2emuproject.proxy.network.meta.interpreter.IntegerInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword as a shortcut's slot on one of the shortcut bars.
 * 
 * @author savormix
 */
public abstract class ShortcutSlot extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	private final int _barSize;
	
	/**
	 * Constructs this interpreter.
	 * 
	 * @param barSize amount of slots in a shortcut bar
	 */
	protected ShortcutSlot(int barSize)
	{
		_barSize = barSize;
	}
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		final L2TextBuilder sb = new L2TextBuilder("Slot: ");
		sb.append(value % _barSize + 1).append(", bar: ").append(value / _barSize + 1);
		return sb.toString();
	}
}
