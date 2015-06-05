/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package modifier;

import net.l2emuproject.proxy.network.meta.modifier.IntegerModifier;
import net.l2emuproject.proxy.script.modifier.ScriptedFieldValueModifier;

/**
 * Decodes a lottery round number to lottery event number (after GoD).
 * 
 * @author savormix
 */
public final class NewLotteryEvent extends ScriptedFieldValueModifier implements IntegerModifier
{
	@Override
	public long apply(long value)
	{
		return value + 65_280;
	}
}
