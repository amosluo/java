package com.amos.test;

import com.amos.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        //Person person = (Person)applicationContext.getBean("person");
        Person person = applicationContext.getBean("person", Person.class);

        System.out.println(person);
    }
}
