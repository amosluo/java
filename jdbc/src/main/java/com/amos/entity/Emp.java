package com.amos.entity;

import java.util.Date;

public class Emp {
    private Integer empno;
    private String ename;
    private Date hiredate;

    public Emp(){

    }

    public Emp(Integer empno, String ename, Date hiredate, Double sal) {
        this.empno = empno;
        this.ename = ename;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                '}';
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    private Double sal;
}
