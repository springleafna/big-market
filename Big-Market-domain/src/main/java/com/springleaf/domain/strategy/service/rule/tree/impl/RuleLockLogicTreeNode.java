package com.springleaf.domain.strategy.service.rule.tree.impl;

import com.springleaf.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.springleaf.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.springleaf.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 次数锁节点（判断抽奖时抽到的奖品是否满足次数限制）
 */
@Slf4j
@Component("rule_lock")
public class RuleLockLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.ALLOW)
                .build();
    }
}
