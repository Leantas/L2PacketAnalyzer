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
 * Shifts value to the left by 24 bits.
 * 
 * @author savormix
 */
public final class ShiftLeft24 extends ScriptedFieldValueModifier implements IntegerModifier
{
	@Override
	public long apply(long value)
	{
		return value << 24;
	}
}
