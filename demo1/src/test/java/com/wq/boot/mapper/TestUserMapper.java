package com.wq.boot.mapper;

import com.wq.boot.pojo.User;
import com.wq.boot.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-15 21:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserMapper {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testGetAllUser(){
        List<User> users = userMapper.getAllUser();
        System.out.println(users);
    }

    @Test
    public void getUser(){

        User u = userMapper.getUser(new User("admin","123456"));
        if(u==null){
            System.out.println("该用户不存在");
        }else {
            System.out.println(u);
        }
    }

    @Test
    public void insertUser(){
        int row = userMapper.insertUser(new User("wq", "111111"));
        System.out.println("成功插入"+row+"条数据");
    }

    @Test
    public void page(){
        List<User> users = userMapper.getAllUser();
        System.out.println("数据总条数为："+users.size());
//        System.out.println(users.get(1));
        List page = Page.page(users, 2, 2);
        System.out.println(page);
    }
}