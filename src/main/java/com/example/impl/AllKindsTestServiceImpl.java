package com.example.impl;

import com.example.HygResponse;
import com.example.req.HealthAssessmentItemDto;
import com.example.service.AllKindsTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/2
 * \* Description:
 * \* @author 王祥栋
 */
@Service
@Slf4j
public class AllKindsTestServiceImpl implements AllKindsTestService {

    public static void main(String[] args) {

        BigDecimal[] bigDecimals = new BigDecimal("180000").divideAndRemainder(new BigDecimal("1000000"));
        System.out.println(bigDecimals[0]+"   "+bigDecimals[1]);
        // 180000 50000
        BigDecimal[] bigDecimals1 = new BigDecimal("180000").divideAndRemainder(new BigDecimal("50000"));
        System.out.println(bigDecimals1[0]+"   "+bigDecimals1[1]);
    }

    @Override
    public void asyncTest() {


    }

    @Async("healthResultExportExecutor")
    @Override
    public HygResponse testAsync() {
            try {
                log.info("睡眠10S,线程名称:{}",Thread.currentThread().getName());
                Thread.sleep(10000L);
                log.info("睡眠结束,线程名称:{}",Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }

        return HygResponse.Success("结束");

    }

    @Override
    public HygResponse demo01() {
        this.testAsync();

        return HygResponse.Success();
    }
}
