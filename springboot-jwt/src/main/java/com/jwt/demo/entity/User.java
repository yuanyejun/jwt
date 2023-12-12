package com.jwt.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 原野
 * @DATE 2023/9/4 10:18
 * @Description:
 * @Version 1.0
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String password;

}
