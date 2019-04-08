package com.worxfr.service.Impl;


import com.worxfr.common.ServerResponse;
import com.worxfr.dao.UserMapper;
import com.worxfr.pojo.User;
import com.worxfr.service.IUserService;
import com.worxfr.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jfunc.json.impl.JSONObject;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    TokenService tokenService;
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public ServerResponse<JSONObject> login(String username, String password) {
        User user = userMapper.login(username, password);

        if(user == null)
            return ServerResponse.createByErrorMessage("登录失败, 用户名或密码错误");

        // 这里使用的密码是加密后的密码
        JSONObject jsonObject=new JSONObject();
        String token = tokenService.getToken(user);
        jsonObject.put("token", token);
        jsonObject.put("user", user);

        return ServerResponse.createBySuccessMessage("登录成功", jsonObject);
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
