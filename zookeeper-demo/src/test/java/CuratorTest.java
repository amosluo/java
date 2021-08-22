import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Before;
import org.junit.Test;

public class CuratorTest {

    // ZooKeeper 锁节点路径, 分布式锁的相关操作都是在这个节点上进行
    private final String lockPath = "/distributed-lock";

    // ZooKeeper 服务地址, 单机格式为:(127.0.0.1:2181),
    // 集群格式为:(127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183)
    private String connectString;
    // Curator 客户端重试策略
    private RetryPolicy retry;
    // Curator 客户端对象
    private CuratorFramework client;
    // client2 用户模拟其他客户端
//    private CuratorFramework client2;

    // 初始化资源
    @Before
    public void init() throws Exception {
        // 设置 ZooKeeper 服务地址为本机的 2181 端口
        connectString = "192.168.3.121:2181,192.168.3.122:2181,192.168.3.123:2181,192.168.3.124:2181/testLock";
        // 重试策略
        // 初始休眠时间为 1000ms, 最大重试次数为 3
        retry = new ExponentialBackoffRetry(1000, 3);
    }

    @Test
    public void test() throws Exception {
        //会话超时时间
        final int SESSION_TIMEOUT = 30 * 1000;

        //连接超时时间
        final int CONNECTION_TIMEOUT = 3 * 1000;

        //ZooKeeper服务地址
        final String CONNECT_ADDR = "";

        System.out.println("jhhhhhhhhhhhhhh");
// 创建一个客户端, 60000(ms)为 session 超时时间, 15000(ms)为链接超时时间
        client = CuratorFrameworkFactory.newClient(connectString, 60000, 15000, retry);
        // 创建会话
        client.start();
        InterProcessLock lock = new InterProcessSemaphoreMutex(client, lockPath);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 获取锁对象
                    try {
                        
                        lock.acquire();
                        System.out.println("1获取锁===============");
                        // 测试锁重入
                        lock.acquire();
                        System.out.println("1再次获取锁===============");
                        Thread.sleep(5 * 1000);
                        lock.release();
                        System.out.println("1释放锁===============");
                        lock.release();
                        System.out.println("1再次释放锁===============");

//                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
//            Thread thread = new Thread(){
//                @Override
//                public void run() {
//                    System.out.println("线程");
//                    //创建连接实例
//                    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//                    //2 通过工厂创建连接
//                    CuratorFramework client = CuratorFrameworkFactory.builder()
//                            .connectString(CONNECT_ADDR).connectionTimeoutMs(CONNECTION_TIMEOUT)
//                            .sessionTimeoutMs(SESSION_TIMEOUT)
//                            //命名空间.namespace("super")
//                            .retryPolicy(retryPolicy)
//                            .build();
//                    //3 开启连接
//                    client.start();
//                    InterProcessMutex mutex = new InterProcessMutex(client, "/abc");
//                    try {
//                        mutex.acquire();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    String name = Thread.currentThread().getName();
//                    System.out.println("当前线程名: " + name);
//                    System.out.println("do work...");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        mutex.release();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    client.close();
//                }
//            };
//            thread.start();
        }

    }
}
