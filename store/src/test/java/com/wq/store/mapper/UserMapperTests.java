package com.wq.store.mapper;

import com.wq.store.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-24 15:54
 */

//标注当前的类是一个测试类，不会随同项目一起打包
@SpringBootTest
//启动单元测试类，参数必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserMapperTests {

    //idea有检测功能，接口是不能直接创建Bean的(底层是SpringBoot动态代理技术来解决)
    //解决办法File-->Setting-->inspections-->Spring Core-->Core
    //            -->Autowiring for bean class-->Severity(Warning)
    @Autowired
    private UserMapper userMapper;
    /**
     * （1）必须使用@Test标注
     * （2）返回值类型必须是void
     * （3）方法的参数列表不指定任何类型
     * （4）方法的访问修饰符必须是public
     */
    @Test
    public void insert(){
        User user=new User();
        user.setUsername("王仟");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
    
    @Test
    public void findByUserName(){
        String username="abd";
        User user = userMapper.findByUserName(username);
        System.out.println("已有用户："+user);
    }



    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(4,
                "456",
                "管理员",
                new Date());
    }
    @Test
    //根据用户的信息查询用户信息
    public void findByUid(){
        System.out.println(userMapper.findByUid(4));
    }

    @Test
    public void updateInfo(){
        User user=new User();
        user.setUid(12);
        user.setPhone("11111111111");
        user.setEmail("111@qq.com");
        user.setGender(0);
        user.setModifiedUser("系统管理员");
        user.setModifiedTime(new Date());
        userMapper.updateInfo(user);
    }


    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(12,"/upload/avatar.png",
                                    "管理员",new Date());
        
    }
}