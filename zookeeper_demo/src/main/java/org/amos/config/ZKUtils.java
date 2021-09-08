package org.amos.config;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZKUtils {
    private static ZooKeeper zk;
    private static String address = "192.168.3.121:2181,192.168.3.122:2181,192.168.3.123:2181,192.168.3.124:2181/mes";
    private static DefaultWatch watch = new DefaultWatch();

    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static ZooKeeper getZk() {
        try {
            zk = new ZooKeeper(address, 1000, watch);
            watch.setCd(countDownLatch);
            countDownLatch.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zk;
    }
}
