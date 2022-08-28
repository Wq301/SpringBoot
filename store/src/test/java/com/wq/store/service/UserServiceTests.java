package com.wq.store.service;

import com.wq.store.pojo.User;
import com.wq.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-24 23:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    UserService userService;
    @Test
    public void reg(){
        try {
            User user=new User();
            user.setUsername("Rory");
            user.setPassword("154782");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            //获取类的对象，再获取类的名称
            System.out.println("注册失败！"+e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user1 = userService.login("Rory", "154782");
        System.out.println("正在登录的用户信息"+user1);
    }

    @Test
    public void changePassword(){
        userService.changePassword(10,"aaa","123","147");
    }


    @Test
    public void getByUid(){
        System.out.println(userService.getByUid(4));
    }
    @Test
    public void changeInfo(){
        User user =new User();
        user.setPhone("198752445663");
        user.setEmail("test@qq.com");
        user.setGender(1);
        userService.changeInfo(13,"数据管理员",user);
    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(12,"/upload/test.png","小明");
    }
}