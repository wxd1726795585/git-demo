package com.example.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * \* Created with WXD.
 * \* Date:  2022/6/23
 * \* Description:测试流
 * \* @author 王祥栋
 */
@Slf4j
public class TestStream {
    public static final  String STRING ="ccc";
    public static void main(String[] args) throws Exception{
        //跳出多重循环
        wc:for (int i = 0; i <100 ; i++) {
            nc:for (int j = 0; j < 90; j++) {
               if (i==1 && j==50){
                   break wc;
               }
            }
        }
        //final关键字
        Stu stu = new Stu();
        stu.setAge(15);
        System.out.println(stu.toString());
    }
    @Test
    private void test(){

    }
    }

@Data
class Stu{
    private  Integer age;

    public static void main(String[] args) {
        System.out.println(TestStream.STRING);
    }
}
