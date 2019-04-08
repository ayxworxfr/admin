package com.worxfr.controller;


import com.worxfr.annotation.PassToken;
import com.worxfr.common.Const;
import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.User;
import com.worxfr.service.IUserService;
import com.worxfr.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jfunc.json.impl.JSONObject;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IUserService userService;


    /**
     * 用户登录
     */
    @PassToken
    @PostMapping("/login")
    public ServerResponse<JSONObject> login(User user, HttpSession session) {
        String md5Password = MD5Util.MD5EncodeUtf8(user.getPassword());

        ServerResponse<JSONObject> serverResponse = userService.loginAdmin(user.getUsername(), md5Password);
        session.setAttribute(Const.RoleCode.ROLE_ADMIN, serverResponse.getData());         // 将信息存入session
        return serverResponse;
    }

    /**
     * 展示所有用户信息
     */
    @PostMapping("/show")
    public ServerResponse<List<User>> show() {
        return userService.selectAllUser();
    }

    /**
     * 添加用户信息
     */
    @PostMapping("/add")
    public ServerResponse<String> add(User user) {
        return userService.regist(user);
    }

    /**
     * 删除用户信息
     */
    @PostMapping("/delete")
    public ServerResponse<String> delete(User user) {
        return userService.deleteByJobId(user.getJobId());
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/update")
    public ServerResponse<String> update(User user) {
        return userService.updateUser(user);
    }
}
