package com.example.daily;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/9
 * \* Description:
 * \* @author 王祥栋
 */
public class SingleTonTest03 {
    public static void main(String[] args) {
        Person person = Person.person;
        Person person1 = Person.person;
        System.out.println(person1.equals(person));
    }
}
class Person{
    private Person(){}
    public static final Person person=new Person();
}
