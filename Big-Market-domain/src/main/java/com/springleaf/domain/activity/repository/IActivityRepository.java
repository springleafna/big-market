package com.springleaf.domain.activity.repository;

import com.springleaf.domain.activity.model.aggregate.CreateOrderAggregate;
import com.springleaf.domain.activity.model.entity.ActivityCountEntity;
import com.springleaf.domain.activity.model.entity.ActivityEntity;
import com.springleaf.domain.activity.model.entity.ActivitySkuEntity;

/**
 * 活动仓储接口
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    void doSaveOrder(CreateOrderAggregate createOrderAggregate);

}
