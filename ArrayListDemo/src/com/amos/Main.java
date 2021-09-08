package com.amos;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List list = new ArrayList();
        list.add(1);
        list.add(true);
        list.add("hello");
        System.out.println(list);
        list.set(1,"luox");
        System.out.println(list);
        System.out.println(list.subList(1,3));


    }
}
