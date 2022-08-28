package com.wq.boot.config;

import com.wq.boot.bean.Car;
import com.wq.boot.bean.Pet;
import com.wq.boot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-18 21:30
 */
@Configuration//标识配置类
@EnableConfigurationProperties(Car.class)//开启Car配置绑定功能，并把该组件自动注册到容器中
public class MyConfig {

    @Bean
    public User user1(){
        return new User("zhangsan",20);
    }

    @Bean
    public User user2(){
        return new User("hahha",18);
    }

    @Bean
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }


}