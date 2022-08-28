package com.wq.boot.service;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wq.boot.mapper.UserMapper;
import com.wq.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-15 21:15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUser(User user) {
        User u = userMapper.getUser(user);
        if (u.getUsername() != null) {
            System.out.println(u);
        }
//        else {
//            System.out.println("该用户不存在");
//        }
        return u;
    }

    @Override
    public int insertUser(User user) {
        int row = userMapper.insertUser(user);
        if (row != 1) {
            System.out.println("添加用户数据异常！");
        } else {
            System.out.println("注册成功");
        }
        return row;
    }


}