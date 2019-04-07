package com.worxfr.controller.admin;

import com.worxfr.common.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    /**
     * 展示所有用户信息
     */
    @PostMapping("/show")
    public ServerResponse<String> show() {
        return ServerResponse.createBySuccess("success");
    }

    /**
     * 添加用户信息
     */
    @PostMapping("/add")
    public ServerResponse<String> add() {
        return ServerResponse.createBySuccess("success");
    }

    /**
     * 删除用户信息
     */
    @PostMapping("/delete")
    public ServerResponse<String> delete() {
        return ServerResponse.createBySuccess("success");
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/update")
    public ServerResponse<String> update() {
        return ServerResponse.createBySuccess("success");
    }
}
