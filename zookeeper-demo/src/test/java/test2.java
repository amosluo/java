import com.amos.lock.WatchCallBack;
import com.amos.lock.zkUtils;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class test2 {

    ZooKeeper zk ;

    @Before
    public void conn () throws IOException, InterruptedException {
        zk  = zkUtils.getZk();
    }

    @After
    public void close (){
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLock() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    WatchCallBack watchCallBack = new WatchCallBack();
                    watchCallBack.setZk(zk);
                    String threadName = Thread.currentThread().getName();
                    watchCallBack.setThreadName(threadName);
                    //每一个线程：
                    //抢锁
                    watchCallBack.tryLock();
                    //干活
                    System.out.println(threadName+" working...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //释放锁
                    watchCallBack.unLock();
                }
            },"Thread " + (i));
            thread.start();
        }

        while (true){
//            Thread.sleep(1000);
        }
    }

}
