package com.amos.controller;

import com.amos.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BirthController {
    @RequestMapping("birth")
    public String birth(User user){
        System.out.println(user);
        return "hello";
    }

    @RequestMapping("reg")
    public String reg(){
        return "birth";
    }
}
