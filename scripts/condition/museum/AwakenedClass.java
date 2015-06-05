/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.museum;

import java.util.Arrays;

import net.l2emuproject.proxy.network.meta.condition.IntegerCondition;
import net.l2emuproject.proxy.script.condition.ScriptedFieldValueCondition;

/**
 * Tests whether the value of a byte/word/dword is either 15-17 or 1003-1005 or 2006-2008.<BR>
 * <BR>
 * Used to check the type of statistic in <TT>MyMuseumRecord</TT> and <TT>TO_BE_NAMED</TT>.
 * 
 * @author savormix
 */
public class AwakenedClass extends ScriptedFieldValueCondition implements IntegerCondition
{
	private static final int[] STATS = { 15, 16, 17, 1003, 1004, 1005, 2006, 2007, 2008 };
	
	@Override
	public boolean test(long value)
	{
		return Arrays.binarySearch(STATS, (int)value) >= 0;
	}
}
