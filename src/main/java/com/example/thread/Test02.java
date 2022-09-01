package com.example.thread;

/**
 * \* Created with WXD.
 * \* Date:  2022/8/29
 * \* Description: 实现Runnable接口
 * \* @author 王祥栋
 */
public class Test02 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"启动了子线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Test02());
        thread.start();
    }
}
