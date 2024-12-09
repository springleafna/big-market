package com.springleaf.infrastructure.persistent.dao;

import com.springleaf.infrastructure.persistent.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface IStrategyRuleDao {
    List<StrategyRule> queryStrategyRuleList();
}
