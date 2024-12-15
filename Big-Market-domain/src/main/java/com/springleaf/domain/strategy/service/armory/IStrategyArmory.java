package com.springleaf.domain.strategy.service.armory;

/**
 * 策略装配库，负责初始化策略计算
 * 根据策略Id初始化策略存入Map集合，供后续抽奖时调用
 */
public interface IStrategyArmory {
    /**
     * 装配抽奖策略配置「触发的时机可以为活动审核通过后进行调用」
     * @param strategyId 策略ID
     * @return 装配结果
     */
    boolean assembleLotteryStrategy(Long strategyId);
}
