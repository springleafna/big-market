package com.springleaf.domain.award.service;

import com.springleaf.domain.award.model.entity.UserAwardRecordEntity;

/**
 * 奖品服务接口
 */
public interface IAwardService {

    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);

}
