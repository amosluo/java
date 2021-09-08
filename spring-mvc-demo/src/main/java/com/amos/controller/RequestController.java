package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {
    @RequestMapping("/testRequest")
    public String testRequest(@RequestParam(value = "userName",required = true, defaultValue = "默认值") String name){
        System.out.println(name);
        return "hello";

    }

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("User-agent") String name){
        System.out.println(name);
        return "hello";

    }

    @RequestMapping("testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String sessionID){
        System.out.println(sessionID);
        return "hello";

    }

    //
}
