package com.worxfr.dao;

import com.worxfr.pojo.Impower;

public interface ImpowerMapper {
    int insert(Impower record);

    int insertSelective(Impower record);
}