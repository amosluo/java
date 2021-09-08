package org.amos.config;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class WatchCallBack implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {

    ZooKeeper zk;
    MyConf conf;
    CountDownLatch cd = new CountDownLatch(1);

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public MyConf getConf() {
        return conf;
    }

    public void setConf(MyConf conf) {
        this.conf = conf;
    }

    @Override
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        if (data != null) {
            String s = new String(data);
            conf.setConf(s);
            cd.countDown();
        }
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        if (stat != null) {
            zk.getData("/AppConf", this, this, "sdfs");
        }

    }

    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                break;
            case NodeDeleted:
                //容忍性
                conf.setConf("");
                cd = new CountDownLatch(1);
                break;
            case NodeCreated:
            case NodeDataChanged:
                zk.getData("/AppConf", this, this, "sdfs");
                break;
            case NodeChildrenChanged:
                break;
        }
    }

    public void aWait() {
        zk.exists("/AppConf", this, this, "sdfs");
        try {
            cd.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
