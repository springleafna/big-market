package com.springleaf.trigger.api;

import com.springleaf.trigger.api.dto.RaffleAwardListRequestDTO;
import com.springleaf.trigger.api.dto.RaffleAwardListResponseDTO;
import com.springleaf.trigger.api.dto.RaffleStrategyRequestDTO;
import com.springleaf.trigger.api.dto.RaffleStrategyResponseDTO;
import com.springleaf.types.model.Response;

import java.util.List;

/**
 * 抽奖服务接口
 */
public interface IRaffleStrategyService {
    /**
     * 策略装配接口
     * @param strategyId 策略Id
     * @return 装配结果
     */
    Response<Boolean> strategyArmory(Long strategyId);

    /**
     * 查询抽奖奖品列表配置
     *
     * @param requestDTO 抽奖奖品列表查询请求参数
     * @return 奖品列表数据
     */
    Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(RaffleAwardListRequestDTO requestDTO);

    /**
     * 随机抽奖接口
     *
     * @param requestDTO 请求参数
     * @return 抽奖结果
     */
    Response<RaffleStrategyResponseDTO> randomRaffle(RaffleStrategyRequestDTO requestDTO);
}
