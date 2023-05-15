package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
class Demo {
    public static void main(String[] args) {
        //资源类
        Date date = new Date();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程开始执行");

            // 线程睡眠3秒
            try {
                TimeUnit.SECONDS.sleep(3);
                date.setNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        log.info("date的数值:-{}-",date.number);
        //模拟线程B：一直在这里等待循环，直到 number 的值不等于零
        while (date.number == 0) {
            System.out.println("11111");
        }

        //只要变量的值被修改，就会执行下面的语句
        System.out.println(Thread.currentThread().getName() + "执行结束");
    }
}

class Date {
    //volatile 保证可见性
    volatile int number;

    public void setNumber() {
        number = 60;
    }
}
