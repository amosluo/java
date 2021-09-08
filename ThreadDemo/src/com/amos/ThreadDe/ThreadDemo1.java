package com.amos.ThreadDe;

public class ThreadDemo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + i + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
