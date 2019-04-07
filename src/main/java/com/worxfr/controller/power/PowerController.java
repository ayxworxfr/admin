package com.worxfr.controller.power;


import com.worxfr.common.ServerResponse;
import com.worxfr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/power")
public class PowerController {

    @Autowired
    IUserService userService;

    /**
     * 添加用户权限
     */
    @PostMapping("/add")
    public ServerResponse<String> addPower() {
        return ServerResponse.createBySuccess("success");
    }

    /**
     * 修改用户权限
     */
    @PostMapping("/update")
    public ServerResponse<String> updatePower() {
        return ServerResponse.createBySuccess("success");
    }

    /**
     * 查询用户权限
     */
    @PostMapping("/search")
    public ServerResponse<String> searchPowers() {
        return ServerResponse.createBySuccess("success");
    }

    /**
     * 删除用户权限
     */
    @PostMapping("/delete")
    public ServerResponse<String> deletePowers() {
        return ServerResponse.createBySuccess("success");
    }


    /**
     * 批量修改用户权限
     */
    @PostMapping("/updates")
    public ServerResponse<String> updatePowers() {
        return ServerResponse.createBySuccess("success");
    }
}
