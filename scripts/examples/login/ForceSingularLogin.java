/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.login;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.l2emuproject.proxy.network.Packet;
import net.l2emuproject.proxy.network.login.client.L2LoginClient;
import net.l2emuproject.proxy.network.login.client.packets.RequestServerLogin;
import net.l2emuproject.proxy.network.login.server.L2LoginServer;
import net.l2emuproject.proxy.script.login.LoginScript;

/**
 * A script that does not allow more than one {@link RequestServerLogin} packet to be sent by the client in the same
 * session.
 * 
 * @author savormix
 */
public final class ForceSingularLogin extends LoginScript
{
	private final Set<Reference<L2LoginClient>> _requestors;
	
	/** Constructs this script. */
	public ForceSingularLogin()
	{
		super(new int[] { RequestServerLogin.OPCODE }, null);
		
		_requestors = new HashSet<Reference<L2LoginClient>>();
	}
	
	@Override
	protected void clientPacketArrived(L2LoginClient sender, L2LoginServer recipient, Packet packet)
	{
		synchronized (ForceSingularLogin.class)
		{
			for (Iterator<Reference<L2LoginClient>> it = _requestors.iterator(); it.hasNext();)
			{
				final Reference<L2LoginClient> ref = it.next();
				final L2LoginClient client = ref.get();
				if (client == null)
					it.remove();
				else if (client == sender)
				{
					packet.demandLoss(this);
					return;
				}
			}
			
			_requestors.add(new WeakReference<L2LoginClient>(sender));
		}
	}
	
	@Override
	public String getScriptName()
	{
		return "Discard duplicate game server login requests";
	}
	
	@Override
	public String getAuthor()
	{
		return "savormix";
	}
	
	@Override
	public String getVersionString()
	{
		return "Valiance";
	}
}
