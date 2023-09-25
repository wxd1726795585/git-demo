package com.example.test;

import com.example.base.BusinessException;
import com.example.entity.CopyEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/15
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
public class TestDemo01 {
    public static void main(String[] args) {
        try {
            TestDemo.test002();
            test01();
        }catch (Exception e){
            throw e;
        }
    }


    public static void test01(){
        int i = 1/0;
    }
}
