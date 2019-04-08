package com.worxfr.dao;

import com.worxfr.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User login(@Param("username") String username, @Param("password") String password);

    User resetPassword(@Param("job_id") String jobId, @Param("phone") String phone);

    int updateByPrimaryKeySelective(User user);

    User selectByJobId(String job_id);

    User findUserById(Integer id);
}