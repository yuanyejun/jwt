package com.jwt.demo.service.impl;

import com.jwt.demo.entity.User;
import com.jwt.demo.mapper.UserDao;
import com.jwt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 原野
 * @DATE 2023/9/4 10:21
 * @Description:
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User login(User user) {
        User u = userDao.login(user);
        if (u != null){
            return u;
        }

        throw  new RuntimeException("登陆失败");
    }
}
