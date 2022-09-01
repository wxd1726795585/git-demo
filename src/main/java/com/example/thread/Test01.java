package com.example.thread;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/8/29
 * \* Description:创建线程  继承Thread类
 * \* @author 王祥栋
 */
@Data
public class Test01 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"启动了子线程");
    }

    public static void main(String[] args) {
        new Test01().start();
    }
}

