package com.example.demo;

import com.example.base.BusinessException;
import org.junit.Test;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/9
 * \* Description:
 * \* @author 王祥栋
 */
public class TestDemo02 {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        throw new BusinessException("测试一个异常");
    }

    public Integer getMath(){
        try {
            int i=1/0;
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 2;
        }finally {
            return 5;
        }
    }
}

