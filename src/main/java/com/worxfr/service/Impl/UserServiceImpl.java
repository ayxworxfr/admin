package com.worxfr.service.Impl;


import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.UserHunt;
import com.worxfr.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public ServerResponse login(UserHunt userHunt) {
        return ServerResponse.createBySuccess("success");
    }

    @Override
    public ServerResponse regist(UserHunt userHunt) {
        return null;
    }
}
