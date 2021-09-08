package com.amos.functionref;

import java.util.function.Consumer;

public class ObjectMethodRef {
    public static void main(String[] args) {
        Consumer<Too> consumer = (i) -> i.foo();
        consumer.accept(new Too());

        Consumer<Too> consumer1 = Too::foo;
        consumer1.accept(new Too());
    }
}

class Too {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("foo");
    }
}

class Too2 {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("foo");
    }
}
