package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class I18nController {
    @RequestMapping("i18n")
    public String i18n(){
        return "login";
    }
}
