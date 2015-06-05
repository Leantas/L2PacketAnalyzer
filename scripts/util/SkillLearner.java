/*
 * Copyright (c) 2012-2015, RaveN Network INC. and/or its affiliates. All rights reserved.
 * RAVEN NETWORK INC. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Licensed Materials - Property of RaveN Network INC.
 * Restricted Rights - Use, duplication or disclosure restricted.
 */
package util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import util.packet.CommonPacketSender;

import eu.revengineer.simplejse.HasScriptDependencies;
import eu.revengineer.simplejse.type.UnloadableScript;

import net.l2emuproject.proxy.network.game.client.L2GameClient;
import net.l2emuproject.proxy.network.game.server.L2GameServer;
import net.l2emuproject.proxy.network.meta.RandomAccessMMOBuffer;
import net.l2emuproject.proxy.script.ScriptFieldAlias;
import net.l2emuproject.proxy.script.game.PpeEnabledGameScript;
import net.l2emuproject.proxy.script.interpreter.L2SkillTranslator;

/**
 * Learns skills by simulating normal user interaction (an alternative would be bulk instant-learn).
 * 
 * @author _dev_
 */
@HasScriptDependencies("util.packet.CommonPacketSender")
public final class SkillLearner extends PpeEnabledGameScript implements UnloadableScript
{
	@ScriptFieldAlias
	private static final String LEARN_SKILL_ID = "LUA_LEARNABLE_SKILL_ID";
	
	private static SkillLearner INSTANCE;
	
	private final Map<L2GameClient, LearnSetup> _activeTasks;
	
	public SkillLearner()
	{
		_activeTasks = new ConcurrentHashMap<>();
	}
	
	public void learnAllApplicableLevels(L2GameClient client, Set<Integer> orderedSkillIDs, LearnEventListener listener) throws IllegalStateException
	{
		final LearnSetup setup = new LearnSetup(orderedSkillIDs, listener);
		final LearnSetup old = _activeTasks.putIfAbsent(client, setup);
		if (old != null)
			throw new IllegalStateException();
		
		setup._state = LearnState.AWAITING_SKILL_LIST;
		setup._failureTask = makeDefaultFailureTask(client, 5_000);
		CommonPacketSender.sendRequestSkillList((L2GameServer)client.getServer());
	}
	
	private ScheduledFuture<?> makeDefaultFailureTask(L2GameClient client, long delayMs)
	{
		final LearnSetup setup = _activeTasks.get(client);
		if (setup == null)
			return null;
		
		return scheduleOnPacketHandlingThread(client, () -> setup._listener.onLearnFailure(L2SkillTranslator.getSkillID(setup._currentlyLearnedSkillNameID)), delayMs, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String getName()
	{
		return "Skill learner";
	}
	
	@Override
	public void onLoad() throws RuntimeException
	{
		INSTANCE = this;
		super.onLoad();
	}
	
	@Override
	public void onUnload() throws RuntimeException
	{
		super.onUnload();
		INSTANCE = null;
		
		for (final Iterator<L2GameClient> it = _activeTasks.keySet().iterator(); it.hasNext();)
		{
			final L2GameClient client = it.next();
			handleDisconnection(client);
			it.remove();
		}
	}
	
	@Override
	public void handleDisconnection(L2GameClient client)
	{
		final LearnSetup setup = _activeTasks.remove(client);
		if (setup == null)
			return;
		
		final ScheduledFuture<?> task = setup._failureTask;
		if (task != null)
			task.cancel(true);
	}
	
	private static final class LearnSetup
	{
		final Set<Integer> _toBeLearned;
		final LearnEventListener _listener;
		LearnState _state;
		int _currentlyLearnedSkillNameID;
		ScheduledFuture<?> _failureTask;
		
		LearnSetup(Set<Integer> toBeLearned, LearnEventListener listener)
		{
			_toBeLearned = toBeLearned;
			_listener = listener;
		}
	}
	
	private enum LearnState
	{
		AWAITING_SKILL_LIST, AWAITING_SKILL_INFO, AWAITING_LEARN_UPDATE;
	}
	
	@Override
	public void handleClientPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
	{
		// nothing
	}
	
	@Override
	public void handleServerPacket(L2GameClient client, L2GameServer server, RandomAccessMMOBuffer buf) throws RuntimeException
	{
		// TODO Auto-generated method stub
		
	}
	
	public interface LearnEventListener
	{
		void onSkillNotAvailable(int skillID);
		
		void onNotEnoughSP(int skillNameID, long currentSP, long requiredSP);
		
		default void onTooLowCharacterLevel(int skillNameID, int currentLevel, int requiredLevel)
		{
			// do nothing; max skill level for current char level is already reached
		}
		
		void onSkillLearn(int skillNameID);
		
		void onLearnFailure(int skillID);
		
		void onCompletion();
	}
}
