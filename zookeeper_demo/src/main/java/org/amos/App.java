package org.amos;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        final CountDownLatch cd = new CountDownLatch(1);
        //zk有session概念，没有连接池概念
        //watch分两类:
        //1、new ZooKeeper()传入，session级别的watch
        //2、getData（）传入，使用一次以后失效（可以通过在watch里面调用zk.getData(path,this,stat)让其一直监控）
        final ZooKeeper zooKeeper = new ZooKeeper("192.168.3.121:2181,192.168.3.122:2181,192.168.3.123:2181,192.168.3.124:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                Event.KeeperState state = watchedEvent.getState();
                java.lang.String path = watchedEvent.getPath();
                Event.EventType type = watchedEvent.getType();
                System.out.println(watchedEvent.toString());
                switch (state) {
                    case Unknown:
                        break;
                    case Disconnected:
                        System.out.println("new zk disconnected");
                        break;
                    case NoSyncConnected:
                        break;
                    case SyncConnected:
                        System.out.println("new zk connected");
                        cd.countDown();
                        break;
                    case AuthFailed:
                        break;
                    case ConnectedReadOnly:
                        break;
                    case SaslAuthenticated:
                        break;
                    case Expired:
                        break;
                }

                switch (type) {
                    case None:
                        break;
                    case NodeCreated:
                        System.out.println("NodeCreated");
                        break;
                    case NodeDeleted:
                        System.out.println("NodeDeleted");
                        break;
                    case NodeDataChanged:
                        System.out.println("NodeDataChanged");
                        break;
                    case NodeChildrenChanged:
                        System.out.println("NodeChildrenChanged");
                        break;
                }
            }
        });

        cd.await();
        ZooKeeper.States state = zooKeeper.getState();
        switch (state) {
            case CONNECTING:
                System.out.println("CONNECTING");
                break;
            case ASSOCIATING:
                break;
            case CONNECTED:
                System.out.println("CONNECTED");
                break;
            case CONNECTEDREADONLY:
                break;
            case CLOSED:
                break;
            case AUTH_FAILED:
                break;
            case NOT_CONNECTED:
                System.out.println("NOT_CONNECTED");
                break;
        }

        //创建节点
        String pathName = zooKeeper.create("/demo1", "123demo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(pathName);

        final Stat stat = new Stat();

        //获取节点数据
        byte[] node = zooKeeper.getData("/demo1", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("getData watch: " + watchedEvent.toString());
                try {
                    zooKeeper.getData("/demo1", this, stat);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, stat);
        System.out.println("取得数据：" + new String(node));

        //修改节点数据
        Stat stat1 = zooKeeper.setData("/demo1", "456456".getBytes(), 0);

        Stat stat2 = zooKeeper.setData("/demo1", "789789".getBytes(), stat1.getVersion());

        //异步回调
        zooKeeper.getData("/demo1", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                System.out.println("-----------async call back------------");
                System.out.println("ctx:" + ctx.toString());
                System.out.println(new String(data));
                print(data);
            }
        },"test");
        System.out.println("-----------async over------------");
        Thread.sleep(2222);
    }

    static void print(byte[] data){
        System.out.println("called:" + new String(data));
    }
}
