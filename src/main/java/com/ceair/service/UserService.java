package com.ceair.service;

import com.ceair.entity.User;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/9-11:20
 */
public interface UserService {
    //保存用户信息
    void save(User user);

    //用户登录
    User login(String username, String password);

    //用户注册
    void reg(User user);

}
