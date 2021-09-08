package com.amos.bean;

public class Person {
    private int id;
    private String name;
    private int age;
    private String gender;

    public Person() {

    }

    public void init(){
        System.out.println("init...");
    }

//    public void destory(){
//        System.out.println("destoried!");
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Person(String name, int id) {
        this.id = id;
        this.name = name;
        System.out.println("Person(String name ,int id)");
    }
//
//    public Person(int id, String name1) {
//        this.id = id;
//        this.name = name1;
//        System.out.println("Person(int id, String name)");
//    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    private void destory() {
        System.out.println("destoried");
    }
}
