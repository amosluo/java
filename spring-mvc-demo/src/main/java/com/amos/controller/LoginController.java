package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {
    /**
     * params: 表示必须包含username参数
     * @param map
     * @return
     */
    @RequestMapping(value = "signIn", params = {"username"}, method = RequestMethod.POST)
    public String signIn(Map<String,String> map){
        System.out.println("hhhhhh");
        return "hello";
    }
}
