/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.network.meta.interpreter.IntegerInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword value as an inventory slot number.
 * 
 * @author savormix
 * @deprecated This was done for HF, so after ExQuestItemList separation in Freya. Needs to be completely redesigned.
 */
@Deprecated
public class InventorySlot extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	/**
	 * Interprets -1.
	 * 
	 * @return -1's interpretation
	 */
	protected String getSpecialInterpretation()
	{
		return "Auto";
	}
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		if (value == -1)
			return getSpecialInterpretation();
		
		return value;
	}
}
