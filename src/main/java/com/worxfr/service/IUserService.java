package com.worxfr.service;


import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.UserHunt;

public interface IUserService {
    ServerResponse login(UserHunt userHunt);
    ServerResponse regist(UserHunt userHunt);
}
