package com.worxfr.dao;

import com.worxfr.pojo.UserHunt;

public interface UserHuntMapper {
    int insert(UserHunt record);

    int insertSelective(UserHunt record);
}