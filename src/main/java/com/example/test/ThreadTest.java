package com.example.test;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/22
 * \* Description:
 * \* @author 王祥栋
 */
public class ThreadTest extends Thread{
    @Override
    public void run() {
        System.out.println("6666666");
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        try {
            Thread.sleep(1000L);
            System.out.println("7777777");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
