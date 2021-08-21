package com.xgy.bookmall.service.impl;

import com.xgy.bookmall.entity.User;
import com.xgy.bookmall.mapper.UserMapper;
import com.xgy.bookmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(int uId) {
        return userMapper.findUserById(uId);
    }

    @Override
    public List<User> findUsersByName(String uName) {
        return userMapper.findUsersByName(uName);
    }

    @Override
    public int insert(String uName, String uPwd, String uPhone) {
        return userMapper.insert(uName, uPwd, uPhone);
    }
}
