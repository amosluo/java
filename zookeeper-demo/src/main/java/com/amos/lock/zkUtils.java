package com.amos.lock;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class zkUtils {
    static ZooKeeper zooKeeper;
    static DefaultWatch watch;
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static ZooKeeper getZk() throws IOException, InterruptedException {
        watch = new DefaultWatch();
        zooKeeper = new ZooKeeper("192.168.3.121:2181,192.168.3.122:2181,192.168.3.123:2181,192.168.3.124:2181/testLock", 2000, watch);
        watch.setCountDownLatch(countDownLatch);
        countDownLatch.await();
        return zooKeeper;
    }
}
