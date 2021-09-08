package com.amos.service;

import com.amos.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    @Autowired
    BaseDao<T> baseDao;

    public void save(){
        System.out.println("自动注入的对象："+baseDao);
        baseDao.save();
    }
}