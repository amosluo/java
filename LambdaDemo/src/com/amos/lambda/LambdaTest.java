package com.amos.lambda;

import com.amos.Student;

import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("插入学生：" + student);
            }
        };
        studentDao.insert(new Student("luox", 52, 30));

        StudentDao studentDao1 = (Student student)-> System.out.println("插入学生2：" + student);
        studentDao1.insert(new Student("luox2", 52, 30));

        StudentDao studentDao2 = (student)-> System.out.println("插入学生3：" + student);
        studentDao2.insert(new Student("luox3", 52, 30));


        //一个输出的函数式接口
        Supplier<String>  supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hello1";
            }
        };
        System.out.println(supplier.get());

        //一个输入，无输出的函数式接口
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + "-" + s);
            }
        };

        consumer.accept("lx");

        //两个输入，无输出的函数式接口
        BiConsumer biConsumer = new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println(o.toString() + o2);
            }
        };
        biConsumer.accept("abc",123);

        //一个输入，一个输出的函数式接口：一般输入和输出类型不同
        Function<Integer,String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "字符串：" + integer;
            }
        };
        System.out.println(function.apply(10));

        //有入参和返回值的函数式接口
        Function<Integer,String> function1 = (i)-> "字符串1:" + i;
        System.out.println(function1.apply(123));

        //一个输入，一个输出的函数式接口：输入和输出类型相同
        UnaryOperator unaryOperator = new UnaryOperator() {
            @Override
            public Object apply(Object o) {
                return o;
            }
        };
        System.out.println(unaryOperator.apply("UnaryOperator"));

        //两个输入，一个输出（输入和输出类型不同）
        BiFunction<Integer,Object,String> biFunction = new BiFunction<Integer, Object, String>() {
            @Override
            public String apply(Integer integer, Object object) {
                return integer + "/" + object;
            }
        };
        System.out.println(biFunction.apply(10,20));

        //两个输入，一个输出（输入和输出类型相同）
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        System.out.println(binaryOperator.apply(10,20));



        //函数式接口
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >10;
            }
        };

        //lambda
        Predicate<Integer> predicate2 = (i)-> i>10;

        //lambda调用外部方法
        Predicate<Integer> predicate3 = (i)-> pre(i);

        System.out.println(predicate.test(15));
        System.out.println(predicate.test(9));
        System.out.println(predicate.test(21));

    }

    private static boolean pre(Integer i) {
        return i> 10;
    }
}
