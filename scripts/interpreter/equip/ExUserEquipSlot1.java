/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.equip;

import net.l2emuproject.proxy.script.interpreter.ScriptedBitmaskInterpreter;

/**
 * Interprets the first slot mask byte of the ExUIEquipSlot packet.
 * 
 * @author _dev_
 */
public class ExUserEquipSlot1 extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public ExUserEquipSlot1()
	{
		super("Weapon", "Headgear", "Ring (top/right)", "Ring (bottom/left)", "Necklace", "Earring (top/right)", "Earring (bottom/left)", "Underwear");
	}
}
