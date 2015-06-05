/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import static java.nio.charset.StandardCharsets.US_ASCII;

import net.l2emuproject.proxy.network.meta.interpreter.ByteArrayInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets given bytes as an ASCII string.
 * 
 * @author _dev_
 */
public class ASCII extends ScriptedFieldValueInterpreter implements ByteArrayInterpreter
{
	@Override
	public Object getInterpretation(byte[] value, ICacheServerID entityCacheContext)
	{
		return new String(value, US_ASCII);
	}
}
