/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package interpreter;

import eu.revengineer.simplejse.type.UnloadableScript;

import net.l2emuproject.proxy.network.meta.container.MetaclassRegistry;
import net.l2emuproject.proxy.network.meta.interpreter.impl.SecondsSinceEpoch;
import net.l2emuproject.proxy.script.ScriptedMetaclass;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;

/**
 * Interprets the given byte/word/dword as a siege time declaration. <BR>
 * <BR>
 * If the given value is zero/negative, it means the siege time is not yet chosen and, if nothing
 * changes, will be chosen automatically.
 * 
 * @author savormix
 */
public class DeclaredSiegeTime extends SecondsSinceEpoch implements UnloadableScript
{
	@Override
	public Object getInterpretation(long value, ICacheServerID entityCacheContext)
	{
		if (value <= 0)
			return "Undecided/Automatic";
		
		return super.getInterpretation(value, entityCacheContext);
	}
	
	@Override
	public String getName()
	{
		return getClass().getSimpleName();
	}
	
	@Override
	public void onLoad() throws RuntimeException
	{
		MetaclassRegistry.getInstance().register(ScriptedMetaclass.getAlias(getClass()), this);
	}
	
	@Override
	public void onUnload() throws RuntimeException
	{
		MetaclassRegistry.getInstance().remove(ScriptedMetaclass.getAlias(getClass()), this);
	}
}
