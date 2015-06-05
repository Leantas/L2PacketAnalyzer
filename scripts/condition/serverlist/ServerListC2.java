/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package condition.serverlist;

import net.l2emuproject.proxy.network.login.client.packets.RequestServerList;
import net.l2emuproject.proxy.network.meta.ServerListTypePublisher;
import net.l2emuproject.proxy.network.meta.condition.IntegerCondition;
import net.l2emuproject.proxy.script.condition.ScriptedFieldValueCondition;

/**
 * A fake condition to test the client-requested list type.
 * 
 * @author _dev_
 */
public final class ServerListC2 extends ScriptedFieldValueCondition implements IntegerCondition, ServerListTypePublisher
{
	@Override
	public boolean test(long value)
	{
		return LIST_TYPE.get() >= RequestServerList.TYPE_C2;
	}
}
