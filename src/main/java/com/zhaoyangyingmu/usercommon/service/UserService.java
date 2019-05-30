package com.zhaoyangyingmu.usercommon.service;

import com.zhaoyangyingmu.usercommon.entity.User;

import java.util.List;


public interface UserService {

    /**
     * 注册成功返回1， 失败返回0
     * */
    int register(User user);

    /**
     * authenticate 进行身份认证，成功返回1， 错误返回0
     * */
    int authenticate(User user);

    List<User> getAllUsers();
}
