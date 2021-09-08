package com.amos.juc;

import java.util.concurrent.BlockingDeque;

public class ProducerQueue implements Runnable {

    BlockingDeque blockingDeque;

    public ProducerQueue(BlockingDeque blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("生产者开始生产商品：" +i);
            try {
                blockingDeque.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
