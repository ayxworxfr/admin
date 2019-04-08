package com.worxfr.service;


import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.User;
import top.jfunc.json.impl.JSONObject;

import java.util.List;

public interface IUserService {

    int checkJobId(String jobId);

    int checkUsername(String username);

    int checkEmail(String email);

    User findUserById(Integer id);

    ServerResponse<List<User>> selectAllUser();

    ServerResponse login(String userName, String password);

    ServerResponse regist(User user);

    ServerResponse resetPassword(String jobId, String phone, String password);

    ServerResponse<String> userMessage(Integer id);

    ServerResponse<String> deleteByJobId(String jobId);

    ServerResponse<String> updateUser(User user);

    ServerResponse<JSONObject> loginAdmin(String username, String md5Password);
}
