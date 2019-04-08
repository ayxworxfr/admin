package com.worxfr.service.Impl;


import com.worxfr.common.ServerResponse;
import com.worxfr.dao.UserMapper;
import com.worxfr.pojo.User;
import com.worxfr.service.IPowerService;
import com.worxfr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PowerServiceImpl implements IPowerService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse add(User user) {
        return null;
    }

    @Override
    public ServerResponse delete(User user) {
        return null;
    }

    @Override
    public ServerResponse update(User user) {
        return null;
    }

    @Override
    public ServerResponse deletes(User user) {
        return null;
    }

    @Override
    public ServerResponse search(User user) {
        return null;
    }
}
