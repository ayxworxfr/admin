package com.worxfr.controller.manage;

import com.worxfr.common.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class ManageController {

    /**
     * 用户登录
     */
    @PostMapping("/delete")
    public ServerResponse delete() {
//        ServerResponse<User> serverResponse = studentService.login(sno, password);
        return ServerResponse.createBySuccess("success");
    }
}
