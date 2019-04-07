package com.worxfr.controller.userhunt;

import com.worxfr.common.Const;
import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.UserHunt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserHuntController {

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ServerResponse login(String jobId, String password) {
//        ServerResponse<UserHunt> serverResponse = studentService.login(sno, password);
        return ServerResponse.createBySuccess("success");
    }
}
