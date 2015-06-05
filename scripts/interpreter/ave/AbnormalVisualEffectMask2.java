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
 * Interprets the given bit mask as displayed abnormal visual effects (extension field).
 * 
 * @author _dev_
 */
@HasScriptDependencies("interpreter.ave.IAbnormalVisualEffect")
public class AbnormalVisualEffectMask2 extends ScriptedBitmaskInterpreter implements IAbnormalVisualEffect
{
	/** Constructs this interpreter. */
	public AbnormalVisualEffectMask2()
	{
		super(Arrays.copyOfRange(EFFECTS, Math.min(EFFECTS.length, 32), Math.min(EFFECTS.length, 64), Object[].class));
	}
}
