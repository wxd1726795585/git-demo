package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/19
 * \* Description:
 * \* @author 王祥栋
 */
@RestController
@Slf4j
public class Test01DemoController {

    @GetMapping("/test/thread")
    public void testThread() throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100000, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i =0;i<=100000;i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    if (name.endsWith("9100")||
                            name.endsWith("9000")||
                            name.endsWith("10000") || name.endsWith("11000")
                            || name.endsWith("12000") || name.endsWith("9200") ||name.endsWith("9300") || name.endsWith("9400")||
                            name.endsWith("9500")|| name.endsWith("9600") ||name.endsWith("9700") ||name.endsWith("9800")
                    ||name.endsWith("9900") || name.endsWith("100")){
                        log.info(name+"正在运行....");
                    }
                     try {
                         Thread.sleep(2000000L);
                     }catch (Exception e){
                         e.printStackTrace();
                     }
                }
            });
        }
    }
}
