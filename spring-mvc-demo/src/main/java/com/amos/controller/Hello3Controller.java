package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

//表示控制器的注解
@Controller
@RequestMapping("3")
public class Hello3Controller {
    //请求的url
    @RequestMapping("hello")
    public String hello2(Map<String, String> map) {
        //往jsp传递的参数
        map.put("hello","spring mvc!");
        //返回jsp页面名称
        return "login";
    }
}
