/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package modifier;

import net.l2emuproject.proxy.network.meta.modifier.DecimalModifier;
import net.l2emuproject.proxy.network.meta.modifier.IntegerModifier;
import net.l2emuproject.proxy.script.modifier.ScriptedFieldValueModifier;

/**
 * Decodes a mutual action ID into a player action ID.
 * 
 * @author savormix
 */
public final class PlusFiftyFive extends ScriptedFieldValueModifier implements IntegerModifier, DecimalModifier
{
	@Override
	public double apply(double value)
	{
		return value + 55D;
	}
	
	@Override
	public long apply(long value)
	{
		return value + 55;
	}
}
