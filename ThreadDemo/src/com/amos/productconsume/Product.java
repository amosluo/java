package com.amos.productconsume;

public class Product implements Runnable {

    Goods goods;
    public Product(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            if(i %2 == 0){
                this.goods.set("娃哈哈","矿泉水");
            }
            else
                this.goods.set("伊利","优酸乳");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
