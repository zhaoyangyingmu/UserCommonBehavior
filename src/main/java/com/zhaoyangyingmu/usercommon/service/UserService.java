package com.zhaoyangyingmu.usercommon.service;

import com.zhaoyangyingmu.usercommon.entity.User;


public interface UserService {

    /**
     * 注册成功返回1， 失败返回0
     * */
    int register(User user);
}
