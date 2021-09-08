package com.amos.factory;

import com.amos.bean.Person;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Person> {
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setName("MyFactoryBean");
        return person;
    }

    public Class<?> getObjectType() {
        return Person.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
