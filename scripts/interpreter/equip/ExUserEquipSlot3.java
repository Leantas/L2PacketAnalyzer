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
 * Interprets the third slot mask byte of the ExUIEquipSlot packet.
 * 
 * @author _dev_
 */
public class ExUserEquipSlot3 extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public ExUserEquipSlot3()
	{
		super("Talisman (5)", "Talisman (4)", "Talisman (3)", "Talisman (2)", "Talisman (1)", "Left Bracelet", "Right Bracelet", "Hair Accessory (bottom)");
	}
}
