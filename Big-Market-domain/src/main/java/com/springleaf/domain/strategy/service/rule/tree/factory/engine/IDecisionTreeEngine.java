package com.springleaf.domain.strategy.service.rule.tree.factory.engine;

import com.springleaf.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * 规则树组合接口：用于组合多个规则树，形成一个大的规则树
 * 工厂外添加引擎:
 * 可以让使得工厂类更加专注于创建对象和组织对象之间的关系，而不涉及具体的业务逻辑
 * 如果处理逻辑需要根据不同的情况而变化，那么可以通过创建不同引擎来实现，而不需要修改工厂的代码
 */
public interface IDecisionTreeEngine {
    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId);
}
