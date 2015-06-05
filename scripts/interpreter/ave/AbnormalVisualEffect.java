/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.ave;

import eu.revengineer.simplejse.HasScriptDependencies;

import net.l2emuproject.proxy.script.interpreter.ScriptedZeroBasedIntegerIdInterpreter;

/**
 * Interprets the given byte/word/dword as an abnormal visual effect.
 * 
 * @author _dev_
 */
@HasScriptDependencies("interpreter.ave.IAbnormalVisualEffect")
public class AbnormalVisualEffect extends ScriptedZeroBasedIntegerIdInterpreter implements IAbnormalVisualEffect
{
	/** Constructs this interpreter. */
	public AbnormalVisualEffect()
	{
		super(new InterpreterMetadata(1), (Object[])EFFECTS);
	}
}
