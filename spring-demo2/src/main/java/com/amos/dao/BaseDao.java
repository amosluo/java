package com.amos.dao;

import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDao<T> {

    public abstract void save();
}
