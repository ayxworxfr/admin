package com.worxfr.service.Impl;


import com.worxfr.common.ServerResponse;
import com.worxfr.dao.UserMapper;
import com.worxfr.pojo.User;
import com.worxfr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse login(String username, String password) {
        User user = userMapper.login(username, password);

        if(user == null)
            return ServerResponse.createByErrorMessage("用户名或密码错误");

        return ServerResponse.createBySuccessMessage("登录成功", user);
    }

    @Override
    public ServerResponse regist(User user) {
        Date time = new Date();
        user.setCreateTime(time);
        user.setUpdateTime(time);
        int result = userMapper.insertSelective(user);

        if(result <= 0)
            return ServerResponse.createByErrorMessage("注册失败");

        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse resetPassword(String jobId, String phone, String password) {
        User user = userMapper.resetPassword(jobId, phone);

        if(user == null)
            return ServerResponse.createByErrorMessage("密码重置失败");

        Date updateTime = new Date();
        user.setUpdateTime(updateTime);
        user.setPassword(password);
        userMapper.updateByPrimaryKeySelective(user);

        return ServerResponse.createBySuccessMessage("密码重置成功");
    }

    @Override
    public ServerResponse userMessage(String jobId) {
        User user = userMapper.selectByJobId(jobId);

        if(user == null)
            return ServerResponse.createByErrorMessage("没有该用户失败");

        return ServerResponse.createBySuccess(user);
    }
}
