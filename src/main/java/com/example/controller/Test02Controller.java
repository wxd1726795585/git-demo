package com.example.controller;

import com.example.impl.Test02ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/27
 * \* Description:
 * \* @author 王祥栋
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class Test02Controller {
    private final Test02ServiceImpl test02Service;
    /**
     * 批量增加数据
     */
    @PostMapping("volume/increase")
    public void volumeIncrease() throws InterruptedException {
        test02Service.volumeIncrease();
    }
}
