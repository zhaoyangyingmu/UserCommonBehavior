package com.zhaoyangyingmu.usercommon.service.impl;

import com.zhaoyangyingmu.usercommon.dao.UserMapper;
import com.zhaoyangyingmu.usercommon.entity.User;
import com.zhaoyangyingmu.usercommon.entity.UserExample;
import com.zhaoyangyingmu.usercommon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int authenticate(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> usersInDb = userMapper.selectByExample(example);
        if (usersInDb.size() == 0) {
            return 0;
        }
        User userInDb = usersInDb.get(0);
        if (userInDb.getPassword().equals(user.getPassword())) {
            return 1;
        }
        return 0;
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectByExample(new UserExample());
    }
}
