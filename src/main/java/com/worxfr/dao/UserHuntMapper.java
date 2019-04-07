package com.worxfr.dao;

import com.worxfr.pojo.UserHunt;
import org.apache.ibatis.annotations.Param;

public interface UserHuntMapper {
    int insert(UserHunt record);

    int insertSelective(UserHunt record);



    UserHunt login(@Param("job_id") String jobId, @Param("password") String password);

    UserHunt resetPassword(@Param("job_id") String jobId, @Param("phone") String phone);

    int updateByPrimaryKeySelective(UserHunt userHunt);

    UserHunt selectByJobId(String job_id);
}