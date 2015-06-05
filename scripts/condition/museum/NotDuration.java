/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.museum;

import eu.revengineer.simplejse.HasScriptDependencies;

/**
 * Tests whether the value of a byte/word/dword is not between 2 and 5.<BR>
 * <BR>
 * Used to check the type of statistic in <TT>MyMuseumRecord</TT> and <TT>TO_BE_NAMED</TT>.
 * 
 * @author savormix
 */
@HasScriptDependencies("condition.museum.Duration")
public class NotDuration extends Duration
{
	@Override
	public boolean test(long value)
	{
		return !super.test(value);
	}
}
