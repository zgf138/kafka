package com.vanvov.kafka.service.impl;

import com.vanvov.kafka.dao.IUserMapper;
import com.vanvov.kafka.domain.User;
import com.vanvov.kafka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {

    //依赖注入
    @Autowired
    IUserMapper userMapper;

    @Override
    public User getUser(String username) {
        return userMapper.findByUsername(username);
    }
}
