package com.jwt.demo.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.jwt.demo.entity.User;
import com.jwt.demo.service.UserService;
import com.jwt.demo.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 原野
 * @DATE 2023/9/4 10:35
 * @Description:
 * @Version 1.0
 */
@RestController
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String,Object> login(User user){

        Map<String, Object> map = new HashMap<>();
        System.out.println(user);

        try {
            User db = userService.login(user);
            HashMap<String, String> tokenMap = new HashMap<>();
            tokenMap.put("username",db.getName());
            tokenMap.put("id",db.getId() + "");
            String token = JWTUtils.getToken(tokenMap);

            map.put("msg","认证成功~~");
            map.put("state",true);
            map.put("token",token);
        } catch (Exception e) {
            map.put("msg","认证失败~~");
            map.put("state",e.getMessage());
        }
        return map;
    }


    @PostMapping("/user/test")
    public Map<String,Object> test(String token){

        HashMap<String, Object> map = new HashMap<>();
//        DecodedJWT jwt = JWTUtils.verifyToken(token);
        map.put("msg","请求成功");
        map.put("state",true);
//        try {
//            DecodedJWT jwt = JWTUtils.verifyToken(token);
//            map.put("msg","请求成功");
//            map.put("state",true);
//            return map;
//
//        } catch (Exception e) {
//            map.put("msg","token无效");
//            map.put("state",false);
//
//        }

        return map;

    }

}
