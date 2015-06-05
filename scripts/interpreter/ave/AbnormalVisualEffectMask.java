/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.ave;

import java.util.Arrays;

import eu.revengineer.simplejse.HasScriptDependencies;

import net.l2emuproject.proxy.script.interpreter.ScriptedBitmaskInterpreter;

/**
 * Interprets the given bit mask as displayed abnormal visual effects.
 * 
 * @author _dev_
 */
@HasScriptDependencies("interpreter.ave.IAbnormalVisualEffect")
public class AbnormalVisualEffectMask extends ScriptedBitmaskInterpreter implements IAbnormalVisualEffect
{
	/** Constructs this interpreter. */
	public AbnormalVisualEffectMask()
	{
		super(Arrays.copyOf(EFFECTS, Math.min(EFFECTS.length, 32), Object[].class));
	}
}
