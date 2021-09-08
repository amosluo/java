package com.amos.ThreadDe;

public class SynchronizedDemo implements Runnable {
    private static int ticket = 5;
    private static Object lck = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lck) {
                if (ticket > 0)
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票");
            }
        }
    }

    public static void main(String[] args) {

        SynchronizedDemo demo =  new SynchronizedDemo();
        SynchronizedDemo demo2 =  new SynchronizedDemo();
        SynchronizedDemo demo3 =  new SynchronizedDemo();
        SynchronizedDemo demo4 =  new SynchronizedDemo();
        Thread t1 = new Thread(demo,"A");
        Thread t2 = new Thread(demo2,"B");
        Thread t3 = new Thread(demo3,"C");
        Thread t4 = new Thread(demo4,"D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
