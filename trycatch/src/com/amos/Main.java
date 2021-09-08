package com.amos;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(test());
        System.out.println(test2());
        System.out.println(getPerson().name);
        System.out.println(getPerson2().name);
        equals();
    }

    static int test() {
        int num = 10;
        try {
            //num += 80;
            return num + 80;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(num);
            if (num > 30)
                System.out.println("num > 30");
            num = 100;
            System.out.println("finally");
            return num;
        }
    }

    static int test2() {
        int num = 10;
        try {
            return num;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (num > 30)
                System.out.println("num > 30");
            num = 100;
            System.out.println("finally");
        }
        System.out.println("out");
        return num;
    }

    static Person getPerson(){
        Person person = new Person();
        person.name = "hello";
        try{
           return person;
        }
        catch (Exception ex) {
        }
        finally {
            person = new Person();
            person.name = "gaici";
            return person;
        }
    }

    static Person getPerson2(){
        Person person = new Person();
        person.name = "hello";
        try{
            return person;
        }
        catch (Exception ex) {
        }
        finally {
            //person = new Person();
            person.name = "gaici";

        }
        return person;
    }

    static void equals(){
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}

class Person{
    public String name;
}
