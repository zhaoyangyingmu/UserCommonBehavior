package com.zhaoyangyingmu.usercommon.service.impl;

import com.zhaoyangyingmu.usercommon.dao.UserMapper;
import com.zhaoyangyingmu.usercommon.entity.User;
import com.zhaoyangyingmu.usercommon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.insertSelective(user);
    }
}
