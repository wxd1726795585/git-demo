package com.example.controller;

import com.example.HygResponse;
import com.example.SingletonPattern;
import com.example.bean.TestBean;
import com.example.utils.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * \* Created with WXD.
 * \* Date:  2023/4/23
 * \* Description:
 * \* @author 王祥栋
 */
@RestController
@Slf4j
public class TestDemoController {
    @Autowired
    @Qualifier("healthResultExportExecutor")
    private AsyncTaskExecutor downloadExecutor;

    @Autowired
    @Qualifier(value = "getTestBean")
    private TestBean testBean;

    @PostMapping("/test/thread")
    public void testThread() throws InterruptedException {
        int i = 5;
        CountDownLatch latch = new CountDownLatch(i);
        for (int j = 0; j < 5; j++) {
            try {
                int k = 1 / 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("***********");
            latch.countDown();
            latch.await();
            log.info("111111");
        }
    }

    @PostMapping("/singletonPattern")
    public void testSingletonPattern() {
        log.info("单例模式,饿汉式的创建");
        SingletonPattern instance = SingletonPattern.getInstance();

    }

    @PostMapping("/getPropertiesValue")
    public HygResponse getPropertiesValue() {
        String property = PropertiesUtil.getProperty("demo", "name", "defaultValue");
        log.info("获取到的值,key:-{}-,value:-{}-", "name", property);
        return HygResponse.Success(property);
    }

    @PostMapping("/getBean")
    public HygResponse getBean() {
        return HygResponse.Success(testBean);
    }



}
