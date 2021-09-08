package com.amos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
public class RedirectController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("redirect")
    public String redirect() {
        String root = servletContext.getContextPath();
        return "redirect:" + root + "/WEB-INF/page/redirect/redirect.jsp";
    }
}
