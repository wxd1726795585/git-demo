package com.example.design;

/**
 * \* Created with WXD.
 * \* Date: 2022/9/7
 * \* Description: 单例设计模式
 * @author WXD
 */
public class SingletonTest {
    /*
    * 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。
    * 并且该类只提供一个取得其对象实例的方法。如果我们要让类在一个虚拟机中只能产生一个对象，
    * 我们首先必须将类的构造器的访问权限设置为 private
    * 这样，就不能用 new 操作符在类的外部产生类的对象了，但在类内部仍可以产生该类的对象。
    * 因为在类的外部开始还无法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象，
    * 静态方法只能访问类中的静态成员变量，所以，指向类内部产生的该类对象的变量也必须定义成静态的。
    * */

    public static void main(String[] args) {
        //饿汉式获取单例
        Bank instance = Bank.getInstance();
    }
}
//饿汉式----单例模式
class Bank{
    /**
     * 1.构造方法的私有化,防止外面通过new创建对象
     */
    private Bank(){}

    /**
     * 2.自己内部先创建好一个对象(为什么要static修饰,因为对外提供的静态方法只能访问静态属性)
     */
    private static Bank bank=new Bank();

    /**
     * 3.对外提供静态方法返回此对象
     * @return
     */
    public static Bank getInstance(){
        return bank;
    }
}