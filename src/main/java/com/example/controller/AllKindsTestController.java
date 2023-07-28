package com.example.controller;

import com.example.service.AllKindsTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/1
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
@RestController
@RequestMapping("/all/kinds")
public class AllKindsTestController {
    @Autowired
    private AllKindsTestService allKindsTestService;
    @PostMapping("/test01")
    public void test01(@RequestParam(value = "name") String name) throws InterruptedException {
        allKindsTestService.asyncTest();
    }


}
