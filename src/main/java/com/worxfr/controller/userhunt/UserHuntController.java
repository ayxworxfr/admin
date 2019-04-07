package com.worxfr.controller.userhunt;

import com.worxfr.common.Const;
import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.UserHunt;
import com.worxfr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserHuntController {

    @Autowired
    IUserService userService;

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ServerResponse<String> login() {
        return ServerResponse.createBySuccess("success");
    }

    /**
     * 用户注册
     */
    @PostMapping("/regist")
    public ServerResponse<String> regist() {
        return ServerResponse.createBySuccess("success");
    }

    /**
     * 展示用户个人信息
     */
    @PostMapping("/message")
    public ServerResponse<String> userMessage() {
        return ServerResponse.createBySuccess("success");
    }
}
