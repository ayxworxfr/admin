package com.worxfr.controller;

import com.worxfr.annotation.UserLoginToken;
import com.worxfr.common.Const;
import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.User;
import com.worxfr.service.IUserService;
import com.worxfr.service.TokenService;
import com.worxfr.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.jfunc.json.impl.JSONObject;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    TokenService tokenService;
    @Autowired
    IUserService userService;

    @UserLoginToken
    @PostMapping("/getMessage")
    public ServerResponse getMessage(){
        return ServerResponse.createBySuccess("你已通过验证");
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ServerResponse<JSONObject> login(User user, HttpSession session) {
        String md5Password = MD5Util.MD5EncodeUtf8(user.getPassword());

        ServerResponse<JSONObject> serverResponse = userService.login(user.getUsername(), md5Password);
        session.setAttribute(Const.CURRENT_USER, serverResponse.getData());         // 将信息存入session
        return serverResponse;
    }

    /**
     * 用户注册
     */
    @PostMapping("/regist")
    public ServerResponse<String> regist(User user) {
        ServerResponse validResponse = this.checkValid(user.getUsername(),Const.USERNAME);
        if(!validResponse.isSuccess()){
            return validResponse;
        }
        validResponse = this.checkValid(user.getEmail(),Const.EMAIL);
        if(!validResponse.isSuccess()){
            return validResponse;
        }
        user.setRoleCode(Const.RoleCode.ROLE_USER);
        //MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        ServerResponse serverResponse = userService.regist(user);

        return serverResponse;
    }

    /**
     * 用户重置密码
     */
    @PostMapping("/resetpassword")
    public ServerResponse<String> resetPassword(User user) {
        //MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        ServerResponse<String> serverResponse = userService.resetPassword(user.getJobId(),user.getPhone(),user.getPassword());
        return serverResponse;
    }

    /**
     * 展示用户个人信息
     */
    @PostMapping("/message")
    public ServerResponse<String> userMessage(String jobId) {
        ServerResponse<String> serverResponse = userService.userMessage(jobId);
        return serverResponse;
    }




    public ServerResponse<String> checkValid(String str,String type){
//        if(org.apache.commons.lang3.StringUtils.isNotBlank(type)){
//            //开始校验
//            if(Const.USERNAME.equals(type)){
//                int resultCount = userService.checkUsername(str);
//                if(resultCount > 0 ){
//                    return ServerResponse.createByErrorMessage("用户名已存在");
//                }
//            }
//            if(Const.EMAIL.equals(type)){
//                int resultCount = userService.checkEmail(str);
//                if(resultCount > 0 ){
//                    return ServerResponse.createByErrorMessage("email已存在");
//                }
//            }
//        }else{
//            return ServerResponse.createByErrorMessage("参数错误");
//        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }
}
