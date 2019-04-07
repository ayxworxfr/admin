package com.worxfr.controller.admin;

import com.worxfr.common.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    public ServerResponse login(String jobId, String password) {
//        ServerResponse<UserHunt> serverResponse = studentService.login(sno, password);
        return ServerResponse.createBySuccess("success");
    }
}
