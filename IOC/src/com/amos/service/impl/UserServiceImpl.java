package com.amos.service.impl;

import com.amos.dao.UserDao;
import com.amos.dao.impl.UserDaoImpl;
import com.amos.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
