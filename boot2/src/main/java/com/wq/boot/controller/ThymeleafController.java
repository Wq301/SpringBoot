package com.wq.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-21 14:11
 */
@Controller
public class ThymeleafController {
    @GetMapping("/success")
    public String thymeleaf(Model model){
        model.addAttribute("msg","Hello,SpringBoot");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}