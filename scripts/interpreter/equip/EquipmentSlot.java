/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.equip;

import net.l2emuproject.proxy.script.interpreter.ScriptedZeroBasedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a legacy equipment slot.
 * 
 * @author _dev_
 */
public class EquipmentSlot extends ScriptedZeroBasedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public EquipmentSlot()
	{
		// @formatter:off
		super(
				"Underwear", // 0
				"Earring (bottom/left)",
				"Earring (top/right)",
				"Necklace",
				"Ring (bottom/left)",
				"Ring (top/right)", // 5
				"Headgear",
				"Weapon",
				"Shield [Sigil]",
				"Gloves",
				"Upper Body", // 10
				"Lower Body",
				"Boots",
				"Cloak",
				"Weapon / Two Handed",
				// TODO: confirm/disprove
				"Hair Accessory (top)", // 15
				"Hair Accessory (bottom)",
				"Right Bracelet",
				"Left Bracelet",
				"Talisman (1)",
				"Talisman (2)", // 20
				"Talisman (3)",
				"Talisman (4)",
				"Talisman (5)",
				"Talisman (6)",
				"Belt", //25
				"Brooch",
				"Jewel (1)",
				"Jewel (2)",
				"Jewel (3)",
				"Jewel (4)", // 30
				"Jewel (5)"
		);
		// @formatter:on
	}
}
