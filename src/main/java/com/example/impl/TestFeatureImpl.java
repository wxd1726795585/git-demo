package com.example.impl;

import com.example.service.TestFeature;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/20
 * \* Description:
 * \* @author 王祥栋
 */
public class TestFeatureImpl implements TestFeature {
    @Override
    public void add() {

    }
}

class Tset001{
    public static void main(String[] args) {
        ((TestFeature)()->{
            System.out.println("aaa");
        }).getDefault();
    }
}
