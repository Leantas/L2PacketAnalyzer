/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter.pledge;

import interpreter.DirectDrawSurface;

import java.awt.image.BufferedImage;

import eu.revengineer.simplejse.HasScriptDependencies;

import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Properly adjusts the DDS texture height for a specific type of crest.
 * 
 * @author _dev_
 */
@HasScriptDependencies("interpreter.DirectDrawSurface")
public class AbstractCrestDDS extends DirectDrawSurface
{
	private final int _width, _height;
	
	/**
	 * Constructs this interpreter.
	 * 
	 * @param width actual crest width
	 * @param height actual crest height
	 */
	protected AbstractCrestDDS(int width, int height)
	{
		_width = width;
		_height = height;
	}
	
	@Override
	public Object getInterpretation(byte[] value, ICacheServerID cacheContext)
	{
		final Object image = super.getInterpretation(value, cacheContext);
		if (image instanceof BufferedImage)
		{
			final BufferedImage x16 = (BufferedImage)image;
			return x16.getSubimage(x16.getWidth() - _width, x16.getHeight() - _height, _width, _height);
		}
		return image;
	}
}
