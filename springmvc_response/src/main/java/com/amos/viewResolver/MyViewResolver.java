package com.amos.viewResolver;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@Component
@Order(1)
public class MyViewResolver implements ViewResolver {
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        System.out.println(viewName);
        if(viewName.startsWith("ams:"))
            return new MyView();
        return null;
    }
}
