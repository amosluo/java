package com.amos.service;

import com.amos.dao.Teacher;
import com.amos.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends BaseService<Teacher> {
    @Autowired
    private TeacherDao teacherDao;

    public void save(){
        teacherDao.save();
    }
}
