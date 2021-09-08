package com.amos.ThreadDe;

public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + i + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        RunnableDemo threadDemo1 = new RunnableDemo();
        Thread thread = new Thread(threadDemo1);
        thread.start();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
