package com.wq.boot.controller;

import com.wq.boot.pojo.User;
import com.wq.boot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-15 20:29
 */
@Controller
public class UserController {
    @RequestMapping("/")
    @ResponseBody
    public String tset() {
        return "Hello";
    }

    @Autowired
    UserServiceImpl userServiceImpl;

    //获取数据库中所有的用户值
    @RequestMapping("/users")
    @ResponseBody
    public List<User> getAllUser() {
        return userServiceImpl.getAllUser();
    }

    //测试查询用户
    @RequestMapping("/user/{username}/{password}")
    public User getUser(User user) {
        User u = userServiceImpl.getUser(user);
        if (u.getUsername() == null && u.getPassword() == null) {
            System.out.println("该用户不存在");
        } else {
            System.out.println(user);
        }
        return user;
    }

    //登录请求
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    //注册请求
    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    //登录成功
    @RequestMapping(value = "/LoginSuccess", method = RequestMethod.GET)
    public String loginSuccess(User user, Model model) {
        try {
            userServiceImpl.getUser(user);
            model.addAttribute("msg", "登录成功");
            return "success";
        } catch (Exception e) {
            model.addAttribute("msg", "登录失败，用户不存在");
            System.out.println("用户不存在！");
            return "redirect:/toLogin";
        }
    }

    //注册成功
    @RequestMapping(value = "/RegisterSuccess", method = RequestMethod.GET)
    public String RegisterSuccess(User user, Model model) {
        userServiceImpl.insertUser(user);
        model.addAttribute("msg", "注册成功，请登录！");
        return "redirect:/toLogin";
    }
}
