package com.wq.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-06-20 10:38
 */
@RestController

public class TestContorller {
    @RequestMapping("/test")
    public String test(){
        return "Test";
    }

    @GetMapping("/car/{id}/{username}")
    public Map<String, Object> test1(@PathVariable("id") Integer id,
                                     @PathVariable("username")String name,
                                     @RequestHeader Map<String,String> handers){

        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("handers",handers);
        return map;
    }

    @GetMapping("/car/3/haha")
    public Map<String, Object> test1(@RequestParam("age")Integer age,
                                     @RequestParam("interts") List<String> interts,
                                     @RequestParam Map<String,String> rp){

        Map<String,Object> map=new HashMap<>();
        map.put("age",age);
        map.put("interts",interts);
        map.put("rp",rp);
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> test2(@RequestBody String context){

        Map<String,Object> map=new HashMap<>();
        map.put("context",context);

        return map;
    }
}