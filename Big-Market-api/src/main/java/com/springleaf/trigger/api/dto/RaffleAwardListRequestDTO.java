package com.springleaf.trigger.api.dto;

import lombok.Data;

/**
 * 抽奖奖品列表，请求对象
 */
@Data
public class RaffleAwardListRequestDTO {

    // 抽奖策略ID
    private Long strategyId;
    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;
}
