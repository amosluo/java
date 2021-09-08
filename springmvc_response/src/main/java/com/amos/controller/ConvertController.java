package com.amos.controller;

import com.amos.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvertController {
    @RequestMapping("submit")
    public String submit(User user2){
        System.out.println(user2);
        return "hello";
    }

    @RequestMapping("info")
    public String info(){
        return "convert";
    }
}
