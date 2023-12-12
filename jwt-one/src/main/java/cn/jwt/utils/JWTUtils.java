package cn.jwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @Author 原野
 * @DATE 2023/9/4 9:49
 * @Description:
 * @Version 1.0
 */
public class JWTUtils {

    private static final String SING = "token!QWERS";

    /**
     * 生成token
     * @return
     */
    public static String getToken(HashMap<String,String> map){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,7);
        JWTCreator.Builder bu = JWT.create();
        map.forEach((k,v)->{
            bu.withClaim(k,v);
        });
        String token = bu.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SING));

        return token;

    }

    /**
     * 验证token
     */

    public static DecodedJWT verifyToken(String token){

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SING)).build();
        return verifier.verify(SING);

    }


}
