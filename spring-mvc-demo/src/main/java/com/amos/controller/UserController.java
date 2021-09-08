package com.amos.controller;

import com.amos.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/addUser")
    public String addUser() {
        return "user";
    }

    @RequestMapping("/testUser")
    public String testUser(User user,User user2) {
        System.out.println(user);
        System.out.println(user2);
        return "success";
    }
}
