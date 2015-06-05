/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.proxy.script.interpreter.ScriptedZeroBasedIntegerIdInterpreter;

/**
 * @author _dev_
 */
public class AdenaDistributionCancelReason extends ScriptedZeroBasedIntegerIdInterpreter
{
	/** Constructs this interpreter. */
	public AdenaDistributionCancelReason()
	{
		// @formatter:off
		super(
				"User action", // for things like re-opening inventory, successfully starting a trade and so on
				null,
				null,
				"Right transfer" // if either party or alliance leader changes
		);
		// @formatter:on
	}
}
