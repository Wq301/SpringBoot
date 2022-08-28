package com.wq.boot.controller;

import com.wq.boot.bean.Car;
import com.wq.boot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-18 16:00
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello,SpringBoot2!";
    }

    @Autowired
    Car car;

    @RequestMapping("/mycar")
    public Car c(){
        return car;
    }


    @Autowired
    User user2;
    @RequestMapping("/user")
    public User uu(){
        return  user2;
    }
}