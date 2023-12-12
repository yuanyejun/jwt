package cn.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @Author 原野
 * @DATE 2023/9/4 9:35
 * @Description:
 * @Version 1.0
 */
public class jwtTest {

    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,120);

        String token = JWT.create()
                .withClaim("username", "zhangsan")
                .withClaim("userid", 21)
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256("token!QWERS"));

        System.out.println("token = " + token);
    }

    @Test
    public void jwtTest(){

        JWTVerifier require = JWT.require(Algorithm.HMAC256("token!QWERS")).build();

        DecodedJWT jwt = require.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTg4MTg1MjEsInVzZXJpZCI6MjEsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.O6M3EbA62dw-ixjmEcc9MLQiwEGcinsUCb-6eLB6oVY");

        System.out.println(jwt.getClaim("username").asString());
        System.out.println(jwt.getClaim("userid").asInt());
        System.out.println("jwt.getExpiresAt() + \"过期时间\" = " + jwt.getExpiresAt() + "过期时间");


    }

}
