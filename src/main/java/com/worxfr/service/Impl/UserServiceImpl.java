package com.worxfr.service.Impl;


import com.worxfr.common.Const;
import com.worxfr.common.ServerResponse;
import com.worxfr.dao.UserMapper;
import com.worxfr.pojo.User;
import com.worxfr.service.IUserService;
import com.worxfr.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jfunc.json.impl.JSONObject;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    TokenService tokenService;
    @Autowired
    UserMapper userMapper;

    @Override
    public int checkJobId(String jobId) {
        int count = userMapper.checkJobId(jobId);
        return count;
    }

    @Override
    public int checkUsername(String username) {
        int count = userMapper.checkUsername(username);
        return count;
    }

    @Override
    public int checkEmail(String email) {
        int count = userMapper.checkEmail(email);
        return count;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public ServerResponse<List<User>> selectAllUser() {
        List<User> users = userMapper.selectAllUser();
        return ServerResponse.createBySuccess(users);
    }

    @Override
    public ServerResponse<JSONObject> login(String username, String md5Password) {
        User user = userMapper.login(username, md5Password);

        if(user == null)
            return ServerResponse.createByErrorMessage("登录失败, 用户名或密码错误");

        // 这里使用的密码是加密后的密码
        JSONObject jsonObject=new JSONObject();
        String token = tokenService.getToken(user);
        jsonObject.put("token", token);

        user.setPassword("");
        jsonObject.put("user", user);
        return ServerResponse.createBySuccessMessage("登录成功", jsonObject);
    }

    @Override
    public ServerResponse regist(User user) {
        Date time = new Date();
        user.setCreateTime(time);
        user.setUpdateTime(time);
        user.setRoleCode(Const.RoleCode.ROLE_USER);
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
    public ServerResponse userMessage(Integer id) {
        User user = userMapper.findUserById(id);

        if(user == null)
            return ServerResponse.createByErrorMessage("没有该用户");

        user.setPassword("");
        return ServerResponse.createBySuccess(user);
    }

    @Override
    public ServerResponse<String> deleteByJobId(String jobId) {
        int count = userMapper.checkJobId(jobId);
        if(count <= 0)
            return ServerResponse.createBySuccessMessage("删除失败，没有该用户");

        userMapper.deleteByJobId(jobId);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<String> updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse<JSONObject> loginAdmin(String username, String md5Password) {
        User user = userMapper.loginAdmin(username, md5Password, Const.RoleCode.ROLE_ADMIN);

        if(user == null)
            return ServerResponse.createByErrorMessage("登录失败");

        // 这里使用的密码是加密后的密码
        JSONObject jsonObject=new JSONObject();
        String token = tokenService.getToken(user);
        jsonObject.put("token", token);

        user.setPassword("");
        jsonObject.put("user", user);
        return ServerResponse.createBySuccessMessage("登录成功", jsonObject);
    }
}
