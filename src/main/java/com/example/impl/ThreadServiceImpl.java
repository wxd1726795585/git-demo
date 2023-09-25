package com.example.impl;

import com.example.HygResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/25
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
@Service
public class ThreadServiceImpl {

    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        Future<?> submit = service1.submit(new Runnable() {
            @Override
            public void run() {
                int i = 1 / 0;
            }
        });
        try {
            Object o = submit.get();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public HygResponse testThread() {
        String randomNumber = getRandomNumber();
        return HygResponse.Success(randomNumber);
    }


    public static synchronized String getRandomNumber() {
        log.info("生成随机数开始了哈");
        try {
            Thread.sleep(5000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 创建一个新的 SecureRandom 对象
        SecureRandom random = new SecureRandom();

        // 生成一个[0, 10)范围内的随机整数
        int num = random.nextInt(10);
        log.info("生成随机数结束了");
        return String.valueOf(num);
    }
}
