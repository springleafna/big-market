package com.springleaf.domain.strategy.service.rule.tree.factory;


import com.springleaf.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.springleaf.domain.strategy.model.valobj.RuleTreeVO;
import com.springleaf.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.springleaf.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import com.springleaf.domain.strategy.service.rule.tree.factory.engine.impl.DecisionTreeEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 规则树工厂
 */
@Service
public class DefaultTreeFactory {

    // 根据bean的名称，获取bean实例
    // 这里的bean实例是由spring管理的，可以直接注入到类中
    // key为"rule_lock", "rule_luck_award", "rule_stock", value为对应的ILogicTreeNode实例
    private final Map<String, ILogicTreeNode> logicTreeNodeGroup;

    public DefaultTreeFactory(Map<String, ILogicTreeNode> logicTreeNodeGroup) {
        this.logicTreeNodeGroup = logicTreeNodeGroup;
    }

    public IDecisionTreeEngine openLogicTree(RuleTreeVO ruleTreeVO) {
        return new DecisionTreeEngine(logicTreeNodeGroup, ruleTreeVO);
    }

    /**
     * 规则树动作实体
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeActionEntity {
        private RuleLogicCheckTypeVO ruleLogicCheckType;
        private StrategyAwardData strategyAwardData;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardData {
        /** 抽奖奖品ID - 内部流转使用 */
        private Integer awardId;
        /** 抽奖奖品规则 */
        private String awardRuleValue;
    }

}
