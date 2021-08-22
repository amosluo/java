import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * zookeper的实现主要有下面四类类:
 * InterProcessMutex：分布式可重入排它锁
 * InterProcessSemaphoreMutex：分布式排它锁
 * InterProcessReadWriteLock：分布式读写锁
 * InterProcessMultiLock：将多个锁作为单个实体管理的容器
 * */
public class DistributedLockDemo {
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
    private CuratorFramework client2;

    // 初始化资源
    @Before
    public void init() throws Exception {
        // 设置 ZooKeeper 服务地址为本机的 2181 端口
        connectString = "192.168.3.121:2181,192.168.3.122:2181,192.168.3.123:2181,192.168.3.124:2181/testLock";
        // 重试策略
        // 初始休眠时间为 1000ms, 最大重试次数为 3
        retry = new ExponentialBackoffRetry(1000, 3);
        // 创建一个客户端, 60000(ms)为 session 超时时间, 15000(ms)为链接超时时间
        client = CuratorFrameworkFactory.newClient(connectString, 60000, 15000, retry);
        client2 = CuratorFrameworkFactory.newClient(connectString, 60000, 15000, retry);
        // 创建会话
        client.start();
        client2.start();
    }

    // 释放资源
    @After
    public void close() {
        CloseableUtils.closeQuietly(client);
    }

    /**
     * 共享锁，不可重入---   InterProcessSemaphoreMutex
     * InterProcessSemaphoreMutex是一种不可重入的互斥锁，也就意味着即使是同一个线程也无法在持有锁的情况下再次获得锁，
     * 所以需要注意，不可重入的锁很容易在一些情况导致死锁
     * */
    @Test
    public void sharedLock() throws Exception {
        // 创建共享锁
        final InterProcessLock lock = new InterProcessSemaphoreMutex(client, lockPath);
        // lock2 用于模拟其他客户端
        final InterProcessLock lock2 = new InterProcessSemaphoreMutex(client2, lockPath);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock.acquire();
                    System.out.println("1获取锁===============");
                    //无法再次获取锁
//                    lock.acquire();
//                    System.out.println("1再次获取锁===============");
                    // 测试锁重入
                    Thread.sleep(1 * 1000);
                    lock.release();
                    System.out.println("1释放锁===============");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock2.acquire();
                    System.out.println("2获取锁===============");
                    Thread.sleep(1 * 1000);
                    //无法再次获取锁
//                    lock.acquire();
//                    System.out.println("2再次获取锁===============");
                    lock2.release();
                    System.out.println("2释放锁===============");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(20 * 1000);
    }

    /**
     * 共享可重入锁---   InterProcessMutex
     * 此锁可以重入，但是重入几次需要释放几次
     * */
    @Test
    public void sharedReentrantLock() throws Exception {
        // 创建共享锁
        final InterProcessLock lock = new InterProcessMutex(client, lockPath);
        // lock2 用于模拟其他客户端
        final InterProcessLock lock2 = new InterProcessMutex(client2, lockPath);

        final CountDownLatch countDownLatch = new CountDownLatch(2);

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

                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock2.acquire();
                    System.out.println("2获取锁===============");
                    // 测试锁重入
                    lock2.acquire();
                    System.out.println("2再次获取锁===============");
                    Thread.sleep(5 * 1000);
                    lock2.release();
                    System.out.println("2释放锁===============");
                    lock2.release();
                    System.out.println("2再次释放锁===============");

                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        countDownLatch.await();
    }

    /**
     * 共享可重入读写锁
     * 读锁和读锁不互斥，只要有写锁就互斥
     * */
    @Test
    public void sharedReentrantReadWriteLock() throws Exception {
        // 创建共享可重入读写锁
        final InterProcessReadWriteLock locl1 = new InterProcessReadWriteLock(client, lockPath);
        // lock2 用于模拟其他客户端
        final InterProcessReadWriteLock lock2 = new InterProcessReadWriteLock(client2, lockPath);

        // 获取读写锁(使用 InterProcessMutex 实现, 所以是可以重入的)
        final InterProcessLock readLock = locl1.readLock();
        final InterProcessLock readLockw = lock2.readLock();

        // 获取写锁(使用 InterProcessMutex 实现, 所以是可以重入的)
        final InterProcessLock writeLock = locl1.writeLock();
        final InterProcessLock writeLockw = lock2.writeLock();

        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    Thread.sleep(1000);
                    readLock.acquire();
                    System.out.println("1获取读锁===============");

//                    writeLock.acquire();
//                    System.out.println("1获取写锁===============");
//
//                    writeLock.acquire();
//                    System.out.println("1再次获取写锁===============");
//                    writeLock.release();
                    Thread.sleep(5 * 1000);

//                    readLock.acquire();
//                    System.out.println("1再次获取读锁===============");
//
//                    readLock.release();
//                    System.out.println("1释放读锁===============");
//
//                    writeLock.release();
//                    System.out.println("1释放写锁===============");

                    readLock.release();
                    System.out.println("1释放读锁===============");





                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    writeLockw.acquire();
                    System.out.println("2获取到写锁--------------");
                    Thread.sleep(3* 1000);
                    writeLockw.release();
                    System.out.println("2释放写锁");
//                    Thread.sleep(500);
//                    readLockw.acquire();
//                    System.out.println("2获取读锁===============");
//                    // 测试锁重入
//                    readLockw.acquire();
//                    System.out.println("2再次获取读锁==============");
//
//                    readLockw.release();
//                    System.out.println("2释放读锁===============");
//
//                    readLockw.release();
//                    System.out.println("2再次释放读锁===============");
//
//                    writeLockw.acquire();
//                    System.out.println("2获取写锁===============");
//
//
//                    Thread.sleep(1 * 1000);
//                    writeLockw.release();
//                    System.out.println("2释放写锁===============");



                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        countDownLatch.await();
    }
}
