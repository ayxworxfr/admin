package com.worxfr.dao;

import com.worxfr.pojo.PowerDetail;

public interface PowerDetailMapper {
    int insert(PowerDetail record);

    int insertSelective(PowerDetail record);
}