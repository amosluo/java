package com.amos.annotation;

import sun.awt.SunHints;

import java.lang.annotation.*;


public class AnnotationTest {
    @MyAnnotation(age = 10, likes = {"1", "2"})
    public void test(@MyAnnotation String name) {

    }
}

//Target用来声明当前自定义注解适用于什么地方，如类，方法，属性，局部变量等；
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
//Retention用于表示当前注解用于什么环境：如 源码级别，类级别或运行时环境，一般是运行时环境
@Retention(RetentionPolicy.RUNTIME)
@Documented
//Inherited表示当前注解能否被继承
@Inherited
@interface MyAnnotation {

    //自定义注解中的所有方法都要在使用注解的时候进行赋值，所以给默认值
    String name() default "luox";

    int age() default 20;

    String[] likes() default {};
}
