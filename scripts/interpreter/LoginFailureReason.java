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
 * Interprets the given byte/word/dword as a reason why you could not log in.
 * 
 * @author savormix
 */
public class LoginFailureReason extends ScriptedLegacyIntegerIdInterpreter
{
	@Override
	protected void loadImpl()
	{
		addInterpretation(1, "There is a system error. Please log in again later.");
		addInterpretation(2, "The password you have entered is incorrect. Confirm your account information and log in again later.");
		addInterpretation(3, "The password you have entered is incorrect. Confirm your account information and log in again later.");
		addInterpretation(4, "Access failed. Please try again later. .");
		addInterpretation(5, "Your account information is incorrect. For more details, please contact our customer service center at http://support.plaync.com.");
		addInterpretation(6, "Access failed. Please try again later. .");
		addInterpretation(7, "Account is already in use. Unable to log in.");
		addInterpretation(8, "Access failed. Please try again later. ."); // shown when server is down
		addInterpretation(9, "Access failed. Please try again later. .");
		addInterpretation(10, "Access failed. Please try again later. .");
		addInterpretation(11, "Access failed. Please try again later. .");
		addInterpretation(12, "Lineage II game services may be used by individuals 15 years of age or older except for PvP servers,"
				+ " which may only be used by adults 18 years of age and older. (Korea Only)");
		addInterpretation(13, "Access failed. Please try again later. .");
		addInterpretation(14, "Access failed. Please try again later. .");
		addInterpretation(15, "Due to high server traffic, your login attempt has failed. Please try again soon.");
		addInterpretation(16, "Currently undergoing game server maintenance. Please log in again later.");
		addInterpretation(17, "Please login after changing your temporary password.");
		addInterpretation(18, "Your game time has expired. To continue playing, please purchase Lineage II either" + " directly from the PlayNC Store or from any leading games retailer.");
		addInterpretation(19, "There is no time left on this account.");
		addInterpretation(20, "System error.");
		addInterpretation(21, "Access failed.");
		addInterpretation(22, "Game connection attempted through a restricted IP.");
		addInterpretation(23, "");
		addInterpretation(30, "This week's usage time has finished.");
		addInterpretation(31, "Invalid security card number, please input another!");
		addInterpretation(32, "Users who have not verified their age may not log in between the hours of 10:00 p.m. and 6:00 a.m.");
		addInterpretation(33, "This server cannot be accessed by the coupon you are using.");
		addInterpretation(35, "You are using a computer that does not allow you to log in with two accounts at the same time.");
		addInterpretation(36, "Your account is currently suspended because you have not logged into the game for some time."
				+ " You may reactivate your account by visiting the PlayNC website (http://www.plaync.com/us/support/).");
		addInterpretation(37, "You must accept the User Agreement before this account can access Lineage II.\n"
				+ "Please try again after accepting the agreement on the PlayNC website (http://www.plaync.co.kr).");
		addInterpretation(38, "A guardian's consent is required before this account can be used to play Lineage II.\n" + "Please try again after this consent is provided.");
		addInterpretation(39, "This account has declined the User Agreement or is pending a withdrawl request. \n" + "Please try again after cancelling this request.");
		addInterpretation(40, "This account has been suspended. \n" + "For more information, please call the Customer's Center (Tel. 1600-0020).");
		addInterpretation(41, "Your account can only be used after changing your password and quiz. \n" + "Services will be available after changing your password and quiz from the PlayNC website "
				+ "(http://www.plaync.co.kr).");
		addInterpretation(42, "You are currently logged into 10 of your accounts and can no longer access your other accounts.");
		addInterpretation(43, "The master account of your account has been restricted.");
	}
}
