package com.jwt.demo.inter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwt.demo.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Author 原野
 * @DATE 2023/9/4 11:19
 * @Description:
 * @Version 1.0
 */
public class JWTinter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HashMap<String, Object> map = new HashMap<>();

        try {
            JWTUtils.verifyToken(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","token无效");
        }
        map.put("state",false);

        String msg = new ObjectMapper().writeValueAsString(map);
        response.setContentType("appplication/json;chatset=UTF-8");
        response.getWriter().println(msg);

        return false;
    }
}
