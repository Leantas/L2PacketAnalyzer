/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.shortcut;

import eu.revengineer.simplejse.HasScriptDependencies;

/**
 * Interprets the given byte/word/dword as a shortcut's slot.
 * 
 * @author savormix
 */
@HasScriptDependencies("interpreter.shortcut.ShortcutSlot")
public class ShortcutSlotBase12 extends ShortcutSlot
{
	/** Constructs this interpreter. */
	public ShortcutSlotBase12()
	{
		super(12);
	}
}
