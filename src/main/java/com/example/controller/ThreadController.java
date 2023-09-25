package com.example.controller;

import com.example.HygResponse;
import com.example.impl.ThreadServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/25
 * \* Description: 关于线程的一些测试东西
 * \* @author 王祥栋
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ThreadController {

    private final ThreadServiceImpl threadService;

    @GetMapping("/testThread")
    public HygResponse testThread(){
        log.info("线程测试----");
        return threadService.testThread();
    }
}
