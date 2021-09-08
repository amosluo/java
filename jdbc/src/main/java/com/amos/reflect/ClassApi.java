package com.amos.reflect;

import com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassApi {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.amos.reflect.Student");

        System.out.println("-------------------获取成员变量(public)--------------------");
        //获取成员变量(public)
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
        }
        System.out.println("-------------------获取类定义的的所有成员变量(包括私有)--------------------");
        //获取类定义的的所有成员变量(包括私有)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
        }
        System.out.println("--------------获取对象属性-------------------------");
        Field field = clazz.getDeclaredField("address");
        field.setAccessible(true); //设置该属性是否能被访问
        Object obj = clazz.newInstance();
        field.set(obj, "hhhhh");
        System.out.println(((Student) obj).getAddress());
        System.out.println("-----------------获取对象的公共方法(含继承的方法)----------------------");
        //获取对象的普通方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());

        }

        System.out.println("-----------------调用对象的方法----------------------");
        Method declaredMethod = clazz.getDeclaredMethod("setAddress", String.class);
        Object o1 = clazz.newInstance();
        declaredMethod.invoke(o1, "luox");
        System.out.println(((Student) o1).getAddress());

        System.out.println("-----------------调用静态方法----------------------");
        Method me = clazz.getDeclaredMethod("sethh", int.class);
        me.invoke(null, 555);

        System.out.println("-----------------获取对象的公有构造方法----------------------");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        System.out.println("-----------------获取对象的所有构造方法----------------------");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("-----------------调用构造方法----------------------");
        Constructor<?> privateConstructor = clazz.getDeclaredConstructor(int.class);
        privateConstructor.setAccessible(true);
        privateConstructor.newInstance(21);
    }
}

class Person {
    public String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("Person...");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    public String className;
    private String address;

    static {

    }

    public Student() {
    }

    public Student(String name, int age, String className, String address) {
        super(name, age);
        this.className = className;
        this.address = address;
    }

    private Student(int age) {
        System.out.println("-----------:" + age);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    static void sethh(int age) {
        System.out.println("static:" + age);
    }
}
