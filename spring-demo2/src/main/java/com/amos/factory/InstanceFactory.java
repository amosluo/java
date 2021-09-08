package com.amos.factory;

import com.amos.bean.Person;

public class InstanceFactory {
    public Person getInstance(String name){
        Person person = new Person();
        person.setName(name);
        return person;
    }
}
