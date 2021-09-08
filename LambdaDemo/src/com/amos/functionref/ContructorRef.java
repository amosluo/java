package com.amos.functionref;

import java.sql.SQLOutput;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ContructorRef {
    public static void main(String[] args) {
        Supplier supplier = () -> new Person();
        supplier.get();
        Supplier supplier2 = Person::new;
        supplier2.get();

        Consumer<String> consumer = (str) -> new Person(str);
        consumer.accept("1213");

        Consumer<String> consumer2 = Person::new;
        consumer2.accept("1213");
        BiFunction<Integer,String,Person> biFunction = Person::new;
        System.out.println(biFunction.apply(12,"45"));
    }
}

class Person {
    public Person() {
        System.out.println("Person无参构造函数");
    }

    public Person(String str) {
        System.out.println("Person有参构造函数:" + str);
    }

    public Person(int i, String str) {
        System.out.println("二参构造函数:" + i + "/ " + str);
    }
}
