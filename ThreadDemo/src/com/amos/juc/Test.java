package com.amos.juc;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {
    public static void main(String[] args) {
        BlockingDeque blockingDeque = new LinkedBlockingDeque(5);
        ProducerQueue producerQueue = new ProducerQueue(blockingDeque);
        CosumerQueue cosumerQueue = new CosumerQueue(blockingDeque);
        new Thread(producerQueue).start();
        new Thread(cosumerQueue).start();
    }
}
