package com.jwt.demo.mapper;

import com.jwt.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 原野
 * @DATE 2023/9/4 10:19
 * @Description:
 * @Version 1.0
 */
@Mapper
public interface UserDao {

    User login(User user);

}
