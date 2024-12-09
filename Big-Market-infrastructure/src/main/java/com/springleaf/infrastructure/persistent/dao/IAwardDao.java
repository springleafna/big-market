package com.springleaf.infrastructure.persistent.dao;

import com.springleaf.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface IAwardDao {
    List<Award> queryAwardList();
}
