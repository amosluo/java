package com.amos.lambda;

import com.amos.Student;

//添加函数试接口注解
@FunctionalInterface
public interface StudentDao {
    void insert(Student student);
}
