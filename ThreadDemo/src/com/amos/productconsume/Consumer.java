package com.amos.productconsume;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class Consumer implements Runnable {
    Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.goods.get();
            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
