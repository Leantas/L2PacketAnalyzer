/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import net.l2emuproject.proxy.network.meta.interpreter.IntegerInterpreter;
import net.l2emuproject.proxy.script.interpreter.ScriptedFieldValueInterpreter;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword as a name/title color.
 * 
 * @author savormix
 */
public class BGR extends ScriptedFieldValueInterpreter implements IntegerInterpreter
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		final int w = 32, h = 14;
		final BufferedImage re = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
		final Graphics2D g = re.createGraphics();
		try
		{
			final int bgr = (int) value;
			final Color c = new Color(bgr & 0xFF, (bgr >> 8) & 0xFF, (bgr >> 16) & 0xFF);
			g.setColor(c);
			g.fillRect(0, 0, w, h);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, w - 1, h - 1);
		}
		finally
		{
			g.dispose();
		}
		return re;
	}
}
