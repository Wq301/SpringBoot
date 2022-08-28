package com.wq.boot;

import com.wq.boot.bean.Car;
import com.wq.boot.bean.Pet;
import com.wq.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-18 15:46
 */
//这是一个SpringBoot应用
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //查看某一类型的组件
        String[] users = run.getBeanNamesForType(User.class);
        for (String user:users) {
            System.out.println("User类型的组件有: " + user);
        }

        //获取组件
        User u = run.getBean("user1",User.class);
        System.out.println("u = " + u);

        Pet p = run.getBean("tomcatPet",Pet.class);
        System.out.println("p = " + p);

        Car cc=run.getBean(Car.class);
        System.out.println("cc = " + cc);
    }
}