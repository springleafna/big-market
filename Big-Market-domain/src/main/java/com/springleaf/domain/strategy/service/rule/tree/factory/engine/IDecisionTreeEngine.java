package com.springleaf.domain.strategy.service.rule.tree.factory.engine;

import com.springleaf.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * 规则树组合接口：用于组合多个规则树，形成一个大的规则树
 */
public interface IDecisionTreeEngine {
    DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);
}
