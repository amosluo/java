package com.amos.dao.impl;

import com.amos.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("获取user对象！");
    }
}
