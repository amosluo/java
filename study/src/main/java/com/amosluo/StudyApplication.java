package com.amosluo;

import com.amosluo.test.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudyApplication.class, args);

        byte a = 10;
        int b = 200;
        byte c = (byte) (b);
        System.out.println(c);
        Math.abs(-10);

        Test test = new Test();
        String str = test.name;

        Child child = new Child("luox");
        child.GetName1();
        child.GetName2();
        child.getAge1();
    }

}

class Parent{
    public String name="parent";
    public Parent() {
        System.out.println("父类构造函数");
    }

    public Parent(String name) {
        this.name = name;
        System.out.println("父类构造函数2");
    }

    public void GetName(){
        System.out.println(name);
    }

    public void getAge(){
        System.out.println(40);
    }
}

class Child extends  Parent{
    public String name="child";

    public Child() {
        System.out.println("子类构造函数");
    }

    public Child(String name){
        //super(name);
        this.name = name;
        System.out.println("子类构造函数2");
    }

    public void GetName(){
        System.out.println(name);
    }

    public void GetName1(){
        GetName();
    }

    public void GetName2(){
        super.GetName();
    }

    public void getAge1(){
        this.getAge();
    }
}

