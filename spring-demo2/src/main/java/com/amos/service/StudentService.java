package com.amos.service;

import com.amos.bean.Student;
import com.amos.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService<Student> {

    @Autowired
    private StudentDao studentDao;

    public void save(){
        studentDao.save();
    }
}