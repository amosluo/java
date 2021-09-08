package com.amos.controller;

import com.amos.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ValidationController {
    @RequestMapping("validation")
    public String validation(@Valid  Person person, BindingResult bindingResult, Model model){
        System.out.println(person);
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Map<String,Object> map = new HashMap<String, Object>();
            for (FieldError fieldError : fieldErrors) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            model.addAttribute("errors",map);

            System.out.println("验证失败");
            return "login";
        } else {
            System.out.println("验证成功");
        }
        return "hello";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
