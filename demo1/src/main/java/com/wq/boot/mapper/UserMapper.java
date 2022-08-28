package com.wq.boot.mapper;

import com.wq.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-15 20:31
 */
@Mapper
public interface UserMapper {
    List<User> getAllUser();

    //    User getUser(@Param("username") String username,@Param("password") String password);
    User getUser(User user);

    int insertUser(User user);

}
