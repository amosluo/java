package com.amos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        gen1();
    }

    static void gen1() {
        Integer[] arr = {2, 5, 8};
        Stream<Integer> stream = Stream.of(arr);
        //stream.forEach(System.out::println);
        int sum = stream.filter((s) -> {
            System.out.println("遍历:" + s);
            return s > 4;
        }).mapToInt(x -> x*10).sum();
        System.out.println(sum);

        System.out.println(Arrays.asList(2,35,7844,66,77,336,4,4566,6,444,33333,787).stream().max((a,b) -> a - b).get());

        System.out.println(Arrays.asList(2,35,7844,1,77,336,4,4566,6,444,33333,787).stream().sorted().findFirst().get());
        System.out.println("---------------------------");
        //Stream转List并打印
        Arrays.asList(2,2,3,1,3,3,4,3,4,3,33333,3).stream().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------------------");
        //Stream转Set并打印
        Arrays.asList(2,2,3,1,3,3,4,3,4,3,33333,3).stream().collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("---------------------------");
        // 从１－５０中跳过１０取２０个数并打印
        Stream.iterate(1, x-> x+1 ).limit(50).skip(10).limit(20).forEach(System.out::println);
        System.out.println("---------------------------");
        Stream.of("11,22,33,44".split(",")).mapToInt(x->Integer.valueOf(x)).forEach(System.out::println);
        System.out.println("---------------------------");
        Stream.of("11,22,33,44".split(",")).mapToInt(Integer:: valueOf).forEach(System.out::println);

        Date date = new Date();
        date.getMinutes();
        show();
    }

    @Deprecated
    static void show(){

    }
}
