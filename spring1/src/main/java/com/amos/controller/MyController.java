package com.amos.controller;

import com.amos.listener.MySessionListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {
//    @RequestMapping("/hello")
//    public String hello(){
//        System.out.println("hello");
//        return "hello";
//    }

    @RequestMapping("/online")
    public String online() {
        return "当前在线人数:" + MySessionListener.online;
    }

    @RequestMapping("thymeleaf")
    public String thymeleaf(ModelMap map, HttpSession session) {
        session.setAttribute("a", "aa");
        session.setAttribute("b", "bb");
        map.put("msg", "测试thymeleaf");
        map.put("msg2", "ModelMap test");
        map.put("userName", "luox");
        map.put("age", "20");
        map.put("isMarry", false);
        map.put("date", new Date());
        List<city> cityList = new ArrayList<>();
        cityList.add(new city(1, "北京"));
        cityList.add(new city(2, "上海"));
        cityList.add(new city(3, "广州"));
        cityList.add(new city(4, "深圳"));
        map.put("list", cityList);
        map.put("cityName", "广州");
        map.put("country","For China");
        map.put("id","12306");
        map.put("info","information");
        return "thymeleaf";
    }
}

class city {
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public city(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "city{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
