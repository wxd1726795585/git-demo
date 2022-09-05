package com.example.demo;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/3
 * \* Description:线程安全问题 加锁
 * \* @author 王祥栋
 */
public class TestDemo02 implements Runnable{
    private static int count=100;
    Object objectLock=new Object();
    @Override
    public void run() {
        while (true){
            if (count>=0){
                try {
                    Thread.sleep(30);
                }catch (Exception e){

                }
                cal();
            }
        }
    }
    private void cal(){
        //synchronized锁代码款  同步代码快
        synchronized (objectLock){
            count--;
            System.out.println(Thread.currentThread().getName()+"——"+count);
        }
    }

    public static void main(String[] args) {
        TestDemo02 testDemo02 = new TestDemo02();
        Thread thread = new Thread(testDemo02);
        Thread thread1 = new Thread(testDemo02);
        thread.start();
        thread1.start();
    }
}
