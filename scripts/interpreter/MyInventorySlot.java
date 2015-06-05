/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import eu.revengineer.simplejse.HasScriptDependencies;

/**
 * Interprets the given byte/word/dword value as an inventory slot number.
 * 
 * @author savormix
 * @deprecated This was done for HF, so after ExQuestItemList separation in Freya. Needs to be completely redesigned.
 */
@Deprecated
@HasScriptDependencies("interpreter.InventorySlot")
public class MyInventorySlot extends InventorySlot
{
	@Override
	protected String getSpecialInterpretation()
	{
		return "Equipped";
	}
}
