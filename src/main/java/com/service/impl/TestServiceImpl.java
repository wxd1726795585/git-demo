package com.service.impl;

import com.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/11
 * \* Description:
 * \* @author 王祥栋
 */
@Service("testService")
@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    public void demo01() {
        BigDecimal bigDecimal = new BigDecimal("2");
    }
}
