package com.amos.juc;

import java.util.concurrent.BlockingDeque;

public class CosumerQueue implements Runnable {

    BlockingDeque blockingDeque;

    public CosumerQueue(BlockingDeque blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("消费者消费了商品：" + blockingDeque.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
