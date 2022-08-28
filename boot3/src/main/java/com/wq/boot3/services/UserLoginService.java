package com.wq.boot3.services;

import com.wq.boot3.bean.UserLogin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-23 20:30
 */
public interface UserLoginService {
    //查询所有的User
    public List<UserLogin> getAllUser();

    //添加User
    public int addUser(UserLogin userLogin);

    //根据用户名查询用户
    public UserLogin queryUserByName(String username);
}
