package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    @RequestMapping("forward")
    public String forward(){
        //System.out.println(servletContext.getRealPath("index.jsp"));
//        return "forward:/index.jsp";
        return "forward:/WEB-INF/page/forward/info.jsp";
    }
}

