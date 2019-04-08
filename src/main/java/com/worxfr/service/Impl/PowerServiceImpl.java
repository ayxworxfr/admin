package com.worxfr.service.Impl;


import com.worxfr.common.ServerResponse;
import com.worxfr.dao.UserHuntMapper;
import com.worxfr.pojo.UserHunt;
import com.worxfr.service.IPowerService;
import com.worxfr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PowerServiceImpl implements IPowerService {

    @Autowired
    UserHuntMapper userHuntMapper;

    @Override
    public ServerResponse add(UserHunt userHunt) {
        return null;
    }

    @Override
    public ServerResponse delete(UserHunt userHunt) {
        return null;
    }

    @Override
    public ServerResponse update(UserHunt userHunt) {
        return null;
    }

    @Override
    public ServerResponse deletes(UserHunt userHunt) {
        return null;
    }

    @Override
    public ServerResponse search(UserHunt userHunt) {
        return null;
    }
}
