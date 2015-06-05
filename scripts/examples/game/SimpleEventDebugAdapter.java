/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package examples.game;

import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.script.analytics.ObjectAnalytics;
import net.l2emuproject.proxy.script.analytics.SimpleEventListener;
import net.l2emuproject.proxy.script.game.HighLevelEventGenerator;
import net.l2emuproject.proxy.script.interpreter.L2SkillTranslator;
import net.l2emuproject.proxy.state.entity.cache.ObjectInfoCache;
import net.l2emuproject.proxy.state.entity.context.ICacheServerID;
import net.l2emuproject.util.logging.L2Logger;

import eu.revengineer.simplejse.init.DisabledScript;
import eu.revengineer.simplejse.type.UnloadableScript;

/**
 * Makes use of {@link HighLevelEventGenerator} class. Instead of dealing with individual packets manually, this class handles events.<BR>
 * <BR>
 * While this class does not depend on packet definitions, the event generator does. Therefore, it is essential that all {@code HLE_} aliases are retained
 * in packet definition XML files. Otherwise, none/only some events will be processed.<BR>
 * Additionally, this class depends on {@link ObjectAnalytics}. Therefore, it is essential that all {@code OIC_} & {@code OIL_} aliases are retained
 * in packet definition XML files. Otherwise, the output will be pretty lame and not very user-readable.
 * 
 * @author _dev_
 */
@DisabledScript
public class SimpleEventDebugAdapter implements SimpleEventListener, UnloadableScript
{
	private static final L2Logger LOG = L2Logger.getLogger(SimpleEventDebugAdapter.class);
	
	@Override
	public void onTargetSelected(L2GameClient client, int selectorOID, int targetOID)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(selectorOID, context) + " targeted " + cache.getOrAdd(targetOID, context));
	}
	
	@Override
	public void onPhysicalAttack(L2GameClient client, int attackerOID, int targetOID)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(attackerOID, context) + " attacked " + cache.getOrAdd(targetOID, context));
	}
	
	@Override
	public void onCast(L2GameClient client, int casterOID, int targetOID, int skill, int level, int castTime, int coolTime)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(casterOID, context) + " started " + L2SkillTranslator.getInterpretation(skill, level) + " on " + cache.getOrAdd(targetOID, context));
		LOG.info("Cast will complete in " + castTime + " ms and skill can be re-cast in " + coolTime + " ms.");
	}
	
	@Override
	public void onCastSuccess(L2GameClient client, int casterOID, int targetOID, int skill, int level)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(casterOID, context) + " executed " + L2SkillTranslator.getInterpretation(skill, level) + " on " + cache.getOrAdd(targetOID, context));
	}
	
	@Override
	public void onCastFailure(L2GameClient client, int casterOID)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(casterOID, context) + " casting failed.");
	}
	
	@Override
	public void onDeath(L2GameClient client, int deceasedOID, boolean sweepable)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(deceasedOID, context) + " died.");
	}
	
	@Override
	public void onRevive(L2GameClient client, int revivedOID)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(revivedOID, context) + " resurrected.");
	}
	
	@Override
	public void onDelete(L2GameClient client, int deletedOID)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(deletedOID, context) + " removed.");
	}
	
	@Override
	public void onItemDrop(L2GameClient client, int dropperOID, int itemOID)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(dropperOID, context) + " dropped " + cache.getOrAdd(itemOID, context));
	}
	
	@Override
	public void onItemSpawn(L2GameClient client, int itemOID)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info("On ground: " + cache.getOrAdd(itemOID, context));
	}
	
	@Override
	public void onItemPickup(L2GameClient client, int finderOID, int itemOID)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(finderOID, context) + " picked up " + cache.getOrAdd(itemOID, context));
	}
	
	@Override
	public void onMovementEnd(L2GameClient client, int stopperOID, int x, int y, int z)
	{
		final ObjectInfoCache cache = ObjectInfoCache.getInstance();
		final ICacheServerID context = ObjectAnalytics.getEntityContext(client);
		LOG.info(cache.getOrAdd(stopperOID, context) + " stopped moving");
	}
	
	@Override
	public void onEffectAdded(L2GameClient client, int skillID)
	{
		LOG.info("Effect gained: " + L2SkillTranslator.getInterpretation(skillID));
	}
	
	@Override
	public void onEffectRemoved(L2GameClient client, int skillID)
	{
		LOG.info("Effect lost: " + L2SkillTranslator.getInterpretation(skillID));
	}
	
	@Override
	public String getName()
	{
		return "Example high-level event processor";
	}
	
	@Override
	public void onLoad() throws RuntimeException
	{
		HighLevelEventGenerator.getInstance().addListener(this);
	}
	
	@Override
	public void onUnload() throws RuntimeException
	{
		HighLevelEventGenerator.getInstance().removeListener(this);
	}
}
