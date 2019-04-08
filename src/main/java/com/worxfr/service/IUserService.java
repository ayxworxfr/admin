package com.worxfr.service;


import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.User;

public interface IUserService {

    User findUserById(Integer id);

    ServerResponse login(String userName, String password);

    ServerResponse regist(User user);

    ServerResponse resetPassword(String jobId, String phone, String password);

    ServerResponse<String> userMessage(String jobId);
}
