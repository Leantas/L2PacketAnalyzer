/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedLegacyIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as a character class (profession) ID.
 * 
 * @author savormix
 */
public class CharacterClass extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		// Harbingers of War (247-304)
		addInterpretation(0, "Human Fighter");
		addInterpretation(1, "Warrior");
		addInterpretation(2, "Gladiator");
		addInterpretation(3, "Warlord");
		addInterpretation(4, "Human Knight");
		addInterpretation(5, "Paladin");
		addInterpretation(6, "Dark Avenger");
		addInterpretation(7, "Rogue");
		addInterpretation(8, "Treasure Hunter");
		addInterpretation(9, "Hawkeye");
		addInterpretation(10, "Human Mystic");
		addInterpretation(11, "Human Wizard");
		addInterpretation(12, "Sorcerer");
		addInterpretation(13, "Necromancer");
		addInterpretation(14, "Warlock");
		addInterpretation(15, "Cleric");
		addInterpretation(16, "Bishop");
		addInterpretation(17, "Prophet");
		addInterpretation(18, "Elven Fighter");
		addInterpretation(19, "Elven Knight");
		addInterpretation(20, "Temple Knight");
		addInterpretation(21, "Swordsinger");
		addInterpretation(22, "Elven Scout");
		addInterpretation(23, "Plains Walker");
		addInterpretation(24, "Silver Ranger");
		addInterpretation(25, "Elven Mystic");
		addInterpretation(26, "Elven Wizard");
		addInterpretation(27, "Spellsinger");
		addInterpretation(28, "Elemental Summoner");
		addInterpretation(29, "Elven Oracle");
		addInterpretation(30, "Elven Elder");
		addInterpretation(31, "Dark Fighter");
		addInterpretation(32, "Palus Knight");
		addInterpretation(33, "Shillien Knight");
		addInterpretation(34, "Bladedancer");
		addInterpretation(35, "Assassin");
		addInterpretation(36, "Abyss Walker");
		addInterpretation(37, "Phantom Ranger");
		addInterpretation(38, "Dark Mystic");
		addInterpretation(39, "Dark Wizard");
		addInterpretation(40, "Spellhowler");
		addInterpretation(41, "Phantom Summoner");
		addInterpretation(42, "Shillien Oracle");
		addInterpretation(43, "Shillen Elder");
		addInterpretation(44, "Orc Fighter");
		addInterpretation(45, "Orc Raider");
		addInterpretation(46, "Destroyer");
		addInterpretation(47, "Orc Monk");
		addInterpretation(48, "Tyrant");
		addInterpretation(49, "Orc Mystic");
		addInterpretation(50, "Orc Shaman");
		addInterpretation(51, "Overlord");
		addInterpretation(52, "Warcryer");
		addInterpretation(53, "Dwarven Fighter");
		addInterpretation(54, "Scavenger");
		addInterpretation(55, "Bounty Hunter");
		addInterpretation(56, "Artisan");
		addInterpretation(57, "Warsmith");
		
		// Scions of Destiny (1159-1189)
		addInterpretation(88, "Duelist");
		addInterpretation(89, "Dreadnought");
		addInterpretation(90, "Phoenix Knight");
		addInterpretation(91, "Hell Knight");
		addInterpretation(92, "Sagittarius");
		addInterpretation(93, "Adventurer");
		addInterpretation(94, "Archmage");
		addInterpretation(95, "Soultaker");
		addInterpretation(96, "Arcana Lord");
		addInterpretation(97, "Cardinal");
		addInterpretation(98, "Hierophant");
		addInterpretation(99, "Eva's Templar");
		addInterpretation(100, "Sword Muse");
		addInterpretation(101, "Wind Rider");
		addInterpretation(102, "Moonlight Sentinel");
		addInterpretation(103, "Mystic Muse");
		addInterpretation(104, "Elemental Master");
		addInterpretation(105, "Eva's Saint");
		addInterpretation(106, "Shillien Templar");
		addInterpretation(107, "Spectral Dancer");
		addInterpretation(108, "Ghost Hunter");
		addInterpretation(109, "Ghost Sentinel");
		addInterpretation(110, "Storm Screamer");
		addInterpretation(111, "Spectral Master");
		addInterpretation(112, "Shillien Saint");
		addInterpretation(113, "Titan");
		addInterpretation(114, "Grand Khavatari");
		addInterpretation(115, "Dominator");
		addInterpretation(116, "Doomcryer");
		addInterpretation(117, "Fortune Seeker");
		addInterpretation(118, "Maestro");
		
		// Kamael (1561-1574)
		addInterpretation(123, "Kamael Soldier (M)");
		addInterpretation(124, "Kamael Soldier (F)");
		addInterpretation(125, "Trooper");
		addInterpretation(126, "Warder");
		addInterpretation(127, "Berserker");
		addInterpretation(128, "Soul Breaker (M)");
		addInterpretation(129, "Soul Breaker (F)");
		addInterpretation(130, "Arbalester");
		addInterpretation(131, "Doombringer");
		addInterpretation(132, "Soul Hound (M)");
		addInterpretation(133, "Soul Hound (F)");
		addInterpretation(134, "Trickster");
		addInterpretation(135, "Inspector");
		addInterpretation(136, "Judicator");
		
		// GoD (2477-2484)
		addInterpretation(139, "Sigel Knight");
		addInterpretation(140, "Tyrr Warrior");
		addInterpretation(141, "Othell Rogue");
		addInterpretation(142, "Yul Archer");
		addInterpretation(143, "Feoh Wizard");
		addInterpretation(144, "Iss Enchanter");
		addInterpretation(145, "Wynn Summoner");
		addInterpretation(146, "Aeore Healer");
		
		// Lindvior (3032-3065)
		addInterpretation(148, "Sigel Phoenix Knight");
		addInterpretation(149, "Sigel Hell Knight");
		addInterpretation(150, "Sigel Eva's Templar");
		addInterpretation(151, "Sigel Shillien Templar");
		addInterpretation(152, "Tyrr Duelist");
		addInterpretation(153, "Tyrr Dreadnought");
		addInterpretation(154, "Tyrr Titan");
		addInterpretation(155, "Tyrr Grand Khavatari");
		addInterpretation(156, "Tyrr Maestro");
		addInterpretation(157, "Tyrr Doombringer");
		addInterpretation(158, "Othell Adventurer");
		addInterpretation(159, "Othell Wind Rider");
		addInterpretation(160, "Othell Ghost Hunter");
		addInterpretation(161, "Othell Fortune Seeker");
		addInterpretation(162, "Yul Sagittarius");
		addInterpretation(163, "Yul Moonlight Sentinel");
		addInterpretation(164, "Yul Ghost Sentinel");
		addInterpretation(165, "Yul Trickster");
		addInterpretation(166, "Feoh Archmage");
		addInterpretation(167, "Feoh Soultaker");
		addInterpretation(168, "Feoh Mystic Muse");
		addInterpretation(169, "Feoh Storm Screamer");
		addInterpretation(170, "Feoh Soulhound");
		addInterpretation(171, "Iss Hierophant");
		addInterpretation(172, "Iss Sword Muse");
		addInterpretation(173, "Iss Spectral Dancer");
		addInterpretation(174, "Iss Dominator");
		addInterpretation(175, "Iss Doomcryer");
		addInterpretation(176, "Wynn Arcana Lord");
		addInterpretation(177, "Wynn Elemental Master");
		addInterpretation(178, "Wynn Spectral Master");
		addInterpretation(179, "Aeore Cardinal");
		addInterpretation(180, "Aeore Eva's Saint");
		addInterpretation(181, "Aeore Shillien Saint");
		
		// Ertheia (3303-3310)
		addInterpretation(182, "Ertheia Fighter");
		addInterpretation(183, "Ertheia Wizard");
		addInterpretation(184, "Marauder");
		addInterpretation(185, "Cloud Breaker");
		addInterpretation(186, "Ripper");
		addInterpretation(187, "Stratomancer");
		addInterpretation(188, "Eviscerator");
		addInterpretation(189, "Sayha's Seer");
	}
}
