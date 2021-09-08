package com.amos.productconsume;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class ProductConsumerTest {
    public static void main(String[] args) {
        Goods goods = new Goods();
        Product product = new Product(goods);
        Consumer consumer = new Consumer(goods);

        Thread t1 = new Thread(product);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();

    }
}
