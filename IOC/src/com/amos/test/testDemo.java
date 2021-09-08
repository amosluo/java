package com.amos.test;

import com.amos.service.UserService;
import com.amos.service.impl.UserServiceImpl;

public class testDemo {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }
}
