package com.example.daily;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/8
 * \* Description:
 * \* @author 王祥栋
 */
public class SingleTonTest01 {
    public static void main(String[] args) {
        //饿汉式单例模式  提前创建好的
        Bank instance = Bank.getInstance();
        Bank instance1 = Bank.getInstance();
        System.out.println(instance.equals(instance1));
    }
}
class Bank{
    private Bank(){}
    private static Bank bank=new Bank();
    public static Bank getInstance(){
        return bank;
    }
}
