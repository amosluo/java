package com.amos.controller;

import com.sun.media.jfxmediaimpl.HostUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewResolverController {
    @RequestMapping("/ams")
    public String testView(){
        System.out.println("testView()");
        return "ams:/index";
    }

    @RequestMapping("/ams2")
    public String testView2(){
        System.out.println("testView2()");
        return "ams2:/index";
    }
}
