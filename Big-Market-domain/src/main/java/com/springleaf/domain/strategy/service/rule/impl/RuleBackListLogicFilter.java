package com.springleaf.domain.strategy.service.rule.impl;


import com.springleaf.domain.strategy.model.entity.RuleActionEntity;
import com.springleaf.domain.strategy.model.entity.RuleMatterEntity;
import com.springleaf.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.springleaf.domain.strategy.repository.IStrategyRepository;
import com.springleaf.domain.strategy.service.annotation.LogicStrategy;
import com.springleaf.domain.strategy.service.rule.ILogicFilter;
import com.springleaf.domain.strategy.service.rule.factory.DefaultLogicFactory;
import com.springleaf.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 【抽奖前规则】黑名单用户过滤规则
 * 传入规则物料实体对象，其中包含用户Id，策略Id，规则模型（rule_blacklist），奖品Id
 * 根据 策略Id，规则模型（rule_blacklist），奖品Id 从strategy_rule中查找该抽奖策略下是否有黑名单规则的用户
 */
@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.RULE_BLACKLIST)
public class RuleBackListLogicFilter implements ILogicFilter<RuleActionEntity.RaffleBeforeEntity> {

    @Resource
    private IStrategyRepository repository;

    @Override
    public RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> filter(RuleMatterEntity ruleMatterEntity) {
        log.info("规则过滤-黑名单 userId:{} strategyId:{} ruleModel:{}", ruleMatterEntity.getUserId(), ruleMatterEntity.getStrategyId(), ruleMatterEntity.getRuleModel());

        String userId = ruleMatterEntity.getUserId();

        // 查询规则值配置
        String ruleValue = repository.queryStrategyRuleValue(ruleMatterEntity.getStrategyId(), ruleMatterEntity.getAwardId(), ruleMatterEntity.getRuleModel());
        //100:user001,user002,user003 取出奖品Id和黑名单用户:{[100],[user001,user002,user003]}
        String[] splitRuleValue = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(splitRuleValue[0]);

        // 过滤其他规则
        // 黑名单用户{user001,user002,user003}
        String[] userBlackIds = splitRuleValue[1].split(Constants.SPLIT);
        for (String userBlackId : userBlackIds) {
            // 查询当前登录用户是否在黑名单中 如果在黑名单中，则接管抽奖，返回默认奖品
            if (userId.equals(userBlackId)) {
                return RuleActionEntity.<RuleActionEntity.RaffleBeforeEntity>builder()
                        .ruleModel(DefaultLogicFactory.LogicModel.RULE_BLACKLIST.getCode())
                        .data(RuleActionEntity.RaffleBeforeEntity.builder()
                                .strategyId(ruleMatterEntity.getStrategyId())
                                .awardId(awardId)
                                .build())
                        .code(RuleLogicCheckTypeVO.TAKE_OVER.getCode())
                        .info(RuleLogicCheckTypeVO.TAKE_OVER.getInfo())
                        .build();
            }
        }

        //未命中黑名单规则，允许继续执行后续规则
        return RuleActionEntity.<RuleActionEntity.RaffleBeforeEntity>builder()
                .code(RuleLogicCheckTypeVO.ALLOW.getCode())
                .info(RuleLogicCheckTypeVO.ALLOW.getInfo())
                .build();
    }

}
