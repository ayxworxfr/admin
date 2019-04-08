package com.worxfr.service;


import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.UserHunt;

public interface IUserService {
    ServerResponse login(String userName, String password);

    ServerResponse regist(UserHunt userHunt);

    ServerResponse resetPassword(String jobId, String phone, String password);

    ServerResponse<String> userMessage(String jobId);
}
