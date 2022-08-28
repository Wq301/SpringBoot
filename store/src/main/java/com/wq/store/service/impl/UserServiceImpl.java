package com.wq.store.service.impl;

import com.wq.store.mapper.UserMapper;
import com.wq.store.pojo.User;
import com.wq.store.service.UserService;
import com.wq.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-24 22:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer reg(User user) {
        //判断用户是否被注册过
        User username = userMapper.findByUserName(user.getUsername());
        if (username != null) {
            //抛出用户名被占用的异常
            throw new UsernameDuplicatedException("用户名被占用");
        }

        //密码的加密处理：避免泄漏。常用md5算法的形式
        //串+password+串-----md5算法进行加密，连续加载三次
        // “串”统称为  盐值，盐值就是一个随机的字符串
        String oldPassword = user.getPassword();
        //随机生成一个盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //补全数据：盐值的记录
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理，忽略原有密码强度提升了数据安全性
        String md5Password = getMD5Password(oldPassword, salt);
        user.setPassword(md5Password);


        //补全数据：is_delete设置成0
        user.setIsDelete(0);

        //补全数据：4个日志字段信息
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);


        //注册,成功：则rows=1
        Integer rows = userMapper.insert(user);
//        System.out.println("影响行数 " + rows);
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
        return rows;
    }

    @Override
    public User login(String username, String password) {
        //(1)根据用户的名称来查询用户的数据是否存在，如果不存在则抛出异常UsernameNoFoundException
        User result = userMapper.findByUserName(username);
        if (result == null) {
            throw new UsernameNoFoundException("用户数据不存在");
        }
        /**(2)检查用户的密码是否匹配:
         *      a、先获取数据库中加密之后的密码
         *      b、获取上次注册时所生成的盐值
         *      c、把用户传递过来的密码按照相同的md5规则进行加密
         *      d、和用户传递过来的密码做比较
         */
        String oldPassword = result.getPassword();
        String oldSalt = result.getSalt();
        String newPassword = getMD5Password(password, oldSalt);
        if (!oldPassword.equals(newPassword)) {
            throw new PasswordNoMatchException("密码不正确");
        }
        //(3)判断is_delete字段值是否为1，表示被删除
        if (result.getIsDelete() == 1) {
            throw new UsernameNoFoundException("该用户已被删除");
        }
        //以更小的数据存储数据，提升系统性能
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        //返回当前的用户数据，目的是为了辅助其他页面做数据展示使用(uid、username、avatar)
        return user;
    }

    @Override
    public void changePassword(Integer uid,
                               String username,
                               String oldPassword,
                               String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNoFoundException("用户数据不存在");
        }
        //原始密码和数据库中的密码进行比较
        String oldmd5Password = getMD5Password(oldPassword, result.getSalt());
        if (!result.getPassword().equals(oldmd5Password)) {
            throw new PasswordNoMatchException("密码错误");
        }
        //将新的密码设置到数据库中，将密码进行加密再去更新
        String newmd5Password = getMD5Password(newPassword, result.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newmd5Password, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据时产生未知的异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNoFoundException("用户没有找到");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNoFoundException("用户没有找到");
        }
        user.setUid(uid);
//        resultUser.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        Integer rows = userMapper.updateInfo(user);
        if (rows != 1) {
            throw new UpdateException("更新数据时产生的未知的异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNoFoundException("用户没有找到");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新用户头像时产生的未知的异常");
        }
    }

    //定义一个md5算法的加密处理
    private String getMD5Password(String password, String salt) {
        //md5加密算法方法的调用(3次)
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}