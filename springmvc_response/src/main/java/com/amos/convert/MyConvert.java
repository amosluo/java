package com.amos.convert;

import com.amos.bean.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MyConvert implements Converter<String, User> {
    public User convert(String source) {
        System.out.println("############" + source);
        User user = null;
        if(source != null && !"".equals(source) && source.split("-").length == 2){
            user = new User();
            user.setName(source.split("-")[0]);
            user.setAge(Integer.parseInt(source.split("-")[1]));
        }
        return user;
    }
}
