package com.worxfr.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.worxfr.common.Const;
import com.worxfr.pojo.User;
import org.springframework.stereotype.Service;
import top.jfunc.json.impl.JSONObject;

import javax.servlet.http.HttpSession;

/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
    public String getTokenBySession(HttpSession httpSession) {
        JSONObject jsonObject = (JSONObject)httpSession.getAttribute(Const.CURRENT_USER);
        String token = null;
        if(jsonObject != null){
            token = (String)jsonObject.get("token");
        }
        return token;
    }
    public String getUserIdByToken(String token) {
        String id= JWT.decode(token).getAudience().get(0);
        return id;
    }
}
