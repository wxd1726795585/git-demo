package com.example.demo;

public class Demo2 {
    public static void main(String[] args) {

        Date2 date2 = new Date2();

        //开启20个线程
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                //每个线程执行1000次++操作
                for (int j = 0; j < 1000; j++) {
                    date2.setNumberPlus();
                }
            }, String.valueOf(i)).start();
        }

        //让20个线程全部执行完
        while (Thread.activeCount() > 2) { //main + GC
            //礼让线程
            Thread.yield();
        }

        //查看最终结果
        System.out.println(date2.number);
    }
}

class Date2 {
    volatile int number;

    public void setNumberPlus() {
        //让其自增
        number++;
    }
}
