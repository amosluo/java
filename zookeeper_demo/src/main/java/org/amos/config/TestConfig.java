package org.amos.config;

import org.apache.zookeeper.ZooKeeper;


public class TestConfig {
    ZooKeeper zk;

    @Before
    public void conn() {
        zk = ZKUtils.getZk();
    }

    @After
    public void closeConn() {
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getConf() {
        WatchCallBack callBack = new WatchCallBack();
        callBack.setZk(zk);
        MyConf conf = new MyConf();
        callBack.setConf(conf);
        callBack.aWait();

        while (true){
            System.out.println(conf.getConf());
        }
    }
}
