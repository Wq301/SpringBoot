package com.wq.boot.service;

import com.wq.boot.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-15 21:14
 */
public interface UserService {
    List<User> getAllUser();

    //    User getUser(@Param("username") String username,@Param("password") String password);
    User getUser(User user);

    int insertUser(User user);


}
