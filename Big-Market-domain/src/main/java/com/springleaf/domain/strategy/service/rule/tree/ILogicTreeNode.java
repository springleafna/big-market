package com.springleaf.domain.strategy.service.rule.tree;


import com.springleaf.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * 规则树接口 - 定义规则树节点的基本操作
 * logic 方法用于执行规则树的逻辑判断 返回接管还是放行 以及 奖励的id 奖品的规则
 */
public interface ILogicTreeNode {

    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId);

}
