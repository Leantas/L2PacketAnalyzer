/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.shortcut;

import net.l2emuproject.proxy.script.condition.ScriptedIntegerEqualityCondition;

/**
 * Tests whether the value of a byte/word/dword is equal to 5. <BR>
 * <BR>
 * Used to check the type of shortcut in <TT>ShortcutList</TT> and <TT>ShortcutAdded</TT>.
 * 
 * @author savormix
 */
public class RecipeShortcut extends ScriptedIntegerEqualityCondition
{
	/** Constructs this interpreter. */
	public RecipeShortcut()
	{
		super(5);
	}
}
