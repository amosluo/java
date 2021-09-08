package com.amos.service;

import com.amos.bean.TblUserRecord;
import com.amos.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username, String password) {
        return tblUserRecordMapper.login(username, password);
    }
}
