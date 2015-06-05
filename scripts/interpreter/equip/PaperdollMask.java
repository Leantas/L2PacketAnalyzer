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
 * Interprets the given bit mask as a legacy paperdoll mask.<BR>
 * <BR>
 * This mask is used on legacy packets, such as ItemList, InventoryUpdate and the like.
 * A few things worth knowing about this mask:<BR>
 * All earrings and all rings have both slots set.<BR>
 * All talismans specify the 1st generic talisman slot, even though bits 23-27 are reserved.
 * 
 * @author savormix
 */
public class PaperdollMask extends ScriptedBitmaskInterpreter
{
	/** Constructs this interpreter. */
	public PaperdollMask()
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
				"One-piece armor", // 15
				"Hair Accessory (top)",
				"Formal wear",
				"Hair Accessory (bottom)",
				"Hair Accessory (both)",
				"Right Bracelet", // 20
				"Left Bracelet",
				"Talisman",
				null,
				null,
				null, // 25
				null,
				null,
				"Belt",
				"Brooch",
				"Jewel" // 30
		);
		// @formatter:on
	}
}
