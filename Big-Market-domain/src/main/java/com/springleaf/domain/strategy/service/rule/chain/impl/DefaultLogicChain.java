package com.springleaf.domain.strategy.service.rule.chain.impl;

import com.springleaf.domain.strategy.service.armory.IStrategyDispatch;
import com.springleaf.domain.strategy.service.rule.chain.AbstractLogicChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 默认的责任链【作为最后一个链】
 */
@Slf4j
@Component("default")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DefaultLogicChain extends AbstractLogicChain {

    @Resource
    protected IStrategyDispatch strategyDispatch;

    @Override
    protected String ruleModel() {
        return "default";
    }

    @Override
    public Integer logic(String userId, Long strategyId) {
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        log.info("抽奖责任链-默认处理 userId: {} strategyId: {} ruleModel: {} awardId: {}", userId, strategyId, ruleModel(), awardId);
        return awardId;
    }
}
