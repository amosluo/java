package com.amos.reflect;

import com.amos.entity.Emp;

public class CreateClassObject {
    public static void main(String[] args) throws Exception {
        //1、通过Class.forName()创建Class对象
        Class clazz = Class.forName("com.amos.entity.Emp");

        //2、通过类名.class
//        Class<Emp> clazz = Emp.class;

        //3、通过对象.getClass;
//        new Emp().getClass()

        System.out.println(clazz.getPackage());
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());
    }
}
