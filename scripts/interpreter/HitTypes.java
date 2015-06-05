/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import net.l2emuproject.lang.L2TextBuilder;
import net.l2emuproject.proxy.network.meta.interpreter.ZeroBasedIntegerIdInterpreter.InterpreterMetadata;
import net.l2emuproject.proxy.script.interpreter.ScriptedBitmaskInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given bit mask as a result of an attack attempt.
 * 
 * @author savormix
 */
public class HitTypes extends ScriptedBitmaskInterpreter
{
	private static final int SS_MASK = 1 << 4;
	private static final String SS_INTERP = "Using soulshot";
	private static final String[] SS_GRADES = { "No", "D", "C", "B", "A", "S", "R", "?" }; // 3 bits = 8 possible values
	
	/** Constructs this interpreter. */
	public HitTypes()
	{
		super(null, (Object)null, null, null, SS_INTERP, "Critical hit", "Deflected by shield", "Missed");
	}
	
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		if ((value & SS_MASK) != SS_MASK)
			return super.getInterpretation(value, entityCacheContext);
		
		final L2TextBuilder sb = new L2TextBuilder(String.valueOf(super.getInterpretation(value, entityCacheContext)));
		final int insertionIdx = sb.indexOf(SS_INTERP) + SS_INTERP.length();
		sb.insert(insertionIdx, ": " + SS_GRADES[(int)(value & 7)] + " grade");
		return sb.moveToString();
	}
}
