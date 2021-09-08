package com.amos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        //匿名内部类方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running1...");
            }
        }).start();

        //Lambda方式
        new Thread(() -> {
            System.out.println("running2...");
        }).start();

        List<String> list = Arrays.asList("wangwu","zhangsan","lisi");
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        for(String str : list){
//            System.out.println(str);
//        }
        list.sort((a,b)-> a.length() - b.length());
        list.forEach(System.out::println);

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("zhangsan", 30, 85));
        arrayList.add(new Student("zhangsan", 25, 75));
        arrayList.add(new Student("zhangsan", 24, 90));
        arrayList.add(new Student("zhangsan", 45, 99));

        Runnable runnable = ()-> System.out.println("hhhh");
        runnable.run();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "called!";
            }
        };
        System.out.println(callable.call());

        Callable<String> callable12 = ()->"called2!";
        System.out.println(callable12.call());
    }
}

