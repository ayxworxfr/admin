package com.worxfr.dao;

import com.worxfr.pojo.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}