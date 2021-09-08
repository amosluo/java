package com.amos.bean;

import java.io.Serializable;
import java.util.Date;

public class Emp  implements Serializable {
    private Integer empno;
    private String name;
    private Integer age;
    private Date birth;
    private Dept dept;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBrith() {
        return birth;
    }

    public void setBrith(Date brith) {
        this.birth = brith;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp() {
    }

    public Emp(String name, Integer age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public Emp(Integer empno, String name, Integer age, Date birth) {
        this.empno = empno;
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", dept=" + dept +
                '}';
    }
}
