package com.amos.productconsume;

public class Goods {
    private String name;
    private String brand;

    private boolean canConsumer = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public synchronized void set(String brand, String name) {
        this.setName(name);
        this.setBrand(brand);
        System.out.println("生产了：" + this.getBrand() + "--" + this.getName());
        canConsumer = true;
        notify();//唤醒执行wait()等待的线程
        try {
            wait(); //使当前线程等待，知道其他线程调用notify()或notifyAll()唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void get() {
        if (canConsumer){
            System.out.println("消费了：" + this.getBrand() + "--" + this.getName());
            canConsumer = false;
            notify();//唤醒线程
        }

        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
