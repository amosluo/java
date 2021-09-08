package com.amos.functionref;

import com.amos.lambda.StudentDao;

import java.util.Random;
import java.util.function.Supplier;

public class Test1 {
    static int put() {
        return new Random().nextInt();
    }

    public static void main(String[] args) {
       Supplier supplier = () -> put();
        Supplier supplier2 = () -> Test1.put();
        Supplier supplier3 = Test1::put;
        System.out.println(supplier.get());
        System.out.println(supplier2.get());
        System.out.println(supplier2.get());
        Supplier supplier4 = Func::hh;
        System.out.println(supplier4.get());
        //System.out::println
    }
}

class Func{
    public static String hh(){
        return "hehe";
    }
}
