package com.amos;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add("1");
        set.add(2);
        set.add(2);
        System.out.println(set);
    }
}
