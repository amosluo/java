package com.amos.controller;

import com.amos.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

@Controller
@SessionAttributes("user2")
public class HelloController {
    Object o1 = null;
    Object o2 = null;
    @Autowired
    private ServletContext servletContext;
    @RequestMapping("hello")
    public String hello() {
        System.out.println("hello！");
        return "hello";
    }

    @RequestMapping("hello2")
    public ModelAndView hello2() {
        System.out.println("hello2！");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping("user")
    public String user(){
        return "user";
    }



    @RequestMapping("signIn")
    public String signIn(@ModelAttribute("user2") User user ,Model model ){
        o2 = model;
        //可以看到所有的model都是同一个对象
        System.out.println(o1==o2);
        System.out.println("--model:" + model);
        System.out.println("--user:" + user);
        return "hello";
    }

    @ModelAttribute
    public void modelUpdate(Model model){
        o1 = model;
        System.out.println("Model model: " + model);
        User user = new User();
        user.setName("lishi");
        user.setAge(12);
        model.addAttribute("user2", user);

        System.out.println("-> Model model: " + model);
    }
}
