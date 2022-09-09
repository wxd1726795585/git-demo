package com.example.daily;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/8
 * \* Description:
 * \* @author 王祥栋
 */
public class SingleTonTest02 {
    public static void main(String[] args) {
        //懒汉式单例模式
        Student instance = Student.getInstance();
        Student instance1 = Student.getInstance();
        System.out.println(instance.equals(instance1));
    }
}
class Student{
    private Student(){}
    private static Student student=null;
    public static Student getInstance(){
        if (student==null){
            student=new Student();
        }
        return student;
    }
}