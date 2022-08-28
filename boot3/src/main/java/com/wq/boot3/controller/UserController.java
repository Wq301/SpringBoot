package com.wq.boot3.controller;

import com.wq.boot3.bean.UserLogin;
import com.wq.boot3.services.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-23 20:33
 */
@Controller
public class UserController {

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @Autowired
    UserLoginServiceImpl userLoginServiceImpl;

    @RequestMapping("/LoginSuccess")
    public String loginSuccess(Model model, UserLogin userLogin) {
        //先查看该用户是否存在
        UserLogin user = userLoginServiceImpl.queryUserByName(userLogin.getUsername());
        if (user != null) {
            System.out.println(user.toString());
            return "success";
        } else {
            //返回到登录界面
            model.addAttribute("msg", "该用户不存在，请先注册");
            return "login";
        }
    }


    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/RegisterSuccess")
    public String toRegisterSuccess(Model model, UserLogin userLogin) {
        int newUser = userLoginServiceImpl.addUser(userLogin);
        System.out.println("新插入的user信息："+newUser);
        System.out.println("数据插入成功！");
        model.addAttribute("msg", "注册成功，可以登录了！");
        return "login";
    }
}