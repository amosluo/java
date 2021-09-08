package com.amos.dao;

import com.amos.bean.Emp;

import java.util.List;

public interface EmpDao {
    public Integer save(Emp emp);
    public Integer update(Emp emp);
    public Integer deleteByEmpno(Integer empno);
    public Emp findByEmpno(Integer empno);
    public List<Emp> selectAll();
    public Emp find1ByEmpno(Integer empno, String name);
    public Emp findDept(Integer empno);
    public Emp find(Emp emp);
}
