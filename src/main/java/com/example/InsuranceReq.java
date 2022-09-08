package com.example;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/4/19
 * \* Description:保险请求参数
 * \* @author 王祥栋
 */
public class InsuranceReq {
    private String test001;

    public void test(){
        System.out.println("test................");
    }
    public void test01(){
        System.out.println("test................");
    }

    public static void main(String[] args) {
        InsuranceReq insuranceReq=new Strudent();
        insuranceReq.test();
    }

}
class Strudent extends InsuranceReq{
    @Override
    public void test() {
        System.out.println("子类....");
    }
    public void test006(){

    }
}
