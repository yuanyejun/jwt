package com.jwt.demo.config;

import com.jwt.demo.inter.JWTinter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 原野
 * @DATE 2023/9/4 11:20
 * @Description:
 * @Version 1.0
 */
@Configuration
public class JWTConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTinter())
                .addPathPatterns("/user/test")
                .excludePathPatterns("/user/login");
    }
}
