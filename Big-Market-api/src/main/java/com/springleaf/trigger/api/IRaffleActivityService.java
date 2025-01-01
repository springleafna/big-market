package com.springleaf.trigger.api;

import com.springleaf.trigger.api.dto.ActivityDrawRequestDTO;
import com.springleaf.trigger.api.dto.ActivityDrawResponseDTO;
import com.springleaf.types.model.Response;

/**
 * 抽奖活动服务
 */
public interface IRaffleActivityService {
    /**
     * 活动装配，数据预热缓存
     * @param activityId 活动ID
     * @return 装配结果
     */
    Response<Boolean> armory(Long activityId);

    /**
     * 活动抽奖接口
     * @param request 请求对象
     * @return 返回结果
     */
    Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request);
}
