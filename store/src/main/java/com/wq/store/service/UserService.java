package com.wq.store.service;

import com.wq.store.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * Description  用户模块业务层接口
 *
 * @author WangQian
 * @create 2022-06-24 22:53
 */
public interface UserService {

    //用户注册方法
    Integer reg(User user);

    /**
     *  用户登录方法
     *  将当前登录成功的用户数据以当前用户对象的形式进行返回。
     *  可以将数据保存在cookie或者session中，避免重复度很高的数据多次频繁操作数据进行获取
     * （id、用户名存放在session中,用户头像存放在cookie中）
     */
    User login(String username,String password);

    //修改用户密码
    void changePassword(Integer uid,
                       String username,
                       String oldPassword,
                       String newPassword);

    //根据用户uid查询用户数据
    User getByUid(Integer uid);
    //更新用户数据
    void changeInfo(Integer uid,String username,User user);

    /**
     * 修改用户头像
     * @param uid
     * @param avatar
     * @param username
     */
    void changeAvatar(Integer uid,String avatar,String username);
}