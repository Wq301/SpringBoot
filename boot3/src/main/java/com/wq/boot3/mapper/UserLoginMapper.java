package com.wq.boot3.mapper;

import com.wq.boot3.bean.UserLogin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-23 20:06
 */
@Mapper
public interface UserLoginMapper {

    //查询所有的User
    public List<UserLogin> getAllUser();

    //添加User
    public int addUser(UserLogin userLogin);

    //根据用户名查询用户
    public UserLogin queryUserByName(String username);
}
