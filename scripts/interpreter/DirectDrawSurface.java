/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;

import net.l2emuproject.proxy.network.meta.interpreter.ByteArrayInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;
import net.l2emuproject.util.logging.L2Logger;

/**
 * Interprets a given byte array as a DirectDraw Surface image.
 * 
 * @author savormix
 */
public class DirectDrawSurface extends ScriptedFieldValueInterpreter implements ByteArrayInterpreter
{
	private static final L2Logger LOG = L2Logger.getLogger(DirectDrawSurface.class);
	
	@Override
	public Object getInterpretation(byte[] value, ICacheServerID cacheContext)
	{
		try
		{
			return ImageIO.read(new ByteArrayInputStream(value));
		}
		catch (Exception e)
		{
			LOG.error("Cannot read DDS image.", e);
		}
		return value;
	}
}
