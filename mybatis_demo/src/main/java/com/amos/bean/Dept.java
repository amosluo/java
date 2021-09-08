package com.amos.bean;

import java.io.Serializable;
import java.util.List;

public class Dept  implements Serializable {
    private Integer deptno;
    private String deptname;
    private List<Emp> emps;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Dept() {
    }

    public Dept(Integer deptno, String deptname) {
        this.deptno = deptno;
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptname='" + deptname + '\'' +
                ", emps=" + emps +
                '}';
    }
}
