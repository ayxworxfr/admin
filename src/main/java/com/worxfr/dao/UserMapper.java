package com.worxfr.dao;

import com.worxfr.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int checkUsername(String username);

    int checkEmail(String email);

    int insertSelective(User record);

    User login(@Param("username") String username, @Param("password") String password);

    User resetPassword(@Param("job_id") String jobId, @Param("phone") String phone);

    int updateByPrimaryKeySelective(User user);

    List<User> selectAllUser();

    User selectByJobId(String job_id);

    User findUserById(Integer id);

    void deleteByJobId(String jobId);

    int checkJobId(String jobId);

    User loginAdmin(@Param("username") String username, @Param("password") String md5Password, @Param ("roleAdmin")String roleAdmin);
}