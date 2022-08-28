package com.wq.boot3.services;

import com.wq.boot3.bean.UserLogin;
import com.wq.boot3.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-23 20:30
 */
@Service
public class UserLoginServiceImpl implements UserLoginService{

    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public List<UserLogin> getAllUser() {
        return userLoginMapper.getAllUser();
    }

    @Override
    public int addUser(UserLogin userLogin) {
        return userLoginMapper.addUser(userLogin);
    }

    @Override
    public UserLogin queryUserByName(String username) {
        return userLoginMapper.queryUserByName(username);
    }
}