package com.amos.controller;

import com.amos.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JsonController {
    @RequestMapping("/json")
    @ResponseBody
    public List<User> json(){
        List<User> users = new ArrayList<User>();
        users.add(new User("luo1",21));
        users.add(new User("luo2",23));
        users.add(new User("luo3",24));
        users.add(new User("luo4",25));

        return users;
    }

    @RequestMapping("test")
    public String test(){
        return "/ajax";
    }
}
