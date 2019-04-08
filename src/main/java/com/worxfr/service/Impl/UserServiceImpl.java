package com.worxfr.service.Impl;


import com.worxfr.common.ServerResponse;
import com.worxfr.dao.UserHuntMapper;
import com.worxfr.pojo.UserHunt;
import com.worxfr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserHuntMapper userHuntMapper;

    @Override
    public ServerResponse login(String username, String password) {
        UserHunt userHunt = userHuntMapper.login(username, password);

        if(userHunt == null)
            return ServerResponse.createByErrorMessage("用户名或密码错误");

        return ServerResponse.createBySuccessMessage("登录成功", userHunt);
    }

    @Override
    public ServerResponse regist(UserHunt userHunt) {
        Date time = new Date();
        userHunt.setCreateTime(time);
        userHunt.setUpdateTime(time);
        int result = userHuntMapper.insertSelective(userHunt);

        if(result <= 0)
            return ServerResponse.createByErrorMessage("注册失败");

        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse resetPassword(String jobId, String phone, String password) {
        UserHunt userHunt = userHuntMapper.resetPassword(jobId, phone);

        if(userHunt == null)
            return ServerResponse.createByErrorMessage("密码重置失败");

        Date updateTime = new Date();
        userHunt.setUpdateTime(updateTime);
        userHunt.setPassword(password);
        userHuntMapper.updateByPrimaryKeySelective(userHunt);

        return ServerResponse.createBySuccessMessage("密码重置成功");
    }

    @Override
    public ServerResponse userMessage(String jobId) {
        UserHunt userHunt = userHuntMapper.selectByJobId(jobId);

        if(userHunt == null)
            return ServerResponse.createByErrorMessage("没有该用户失败");

        return ServerResponse.createBySuccess(userHunt);
    }
}
