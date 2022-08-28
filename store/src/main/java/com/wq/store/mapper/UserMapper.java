package com.wq.store.mapper;

import com.wq.store.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Description  用户模块的持久层接口
 *
 * @author WangQian
 * @create 2022-06-24 15:20
 */

public interface UserMapper {

    //插入用户的数据，返回受影响的行数
    Integer insert(User user);

    //根据用户名来查询用户的数据，如果找到则返回这个用户数据，如果没有找到返回null值
    User findByUserName(String username);

    //根据用户的uid修改用户密码
    Integer updatePasswordByUid(Integer uid,
                                String password,  //新密码
                                String modifiedUser,   //修改的执行者
                                Date modifiedTime);   //修改数据的时间
    //根据用户的信息查询用户信息
    User findByUid(Integer uid);


    //更新用户的数据信息
    Integer updateInfo(User user);

    //根据用户的uid来修改用户的头像
    //@Param将SQL语句的占位符和映射的接口方法参数名保持一致
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar") String avatar,
                              @Param("modifiedUser") String modifiedUser,
                              @Param("modifiedTime") Date modifiedTime);

}
