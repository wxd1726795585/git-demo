package com.example.controller;

import com.example.HygResponse;
import com.example.impl.Test02ServiceImpl;
import com.example.req.StudentInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/start")
    public HygResponse start() {
        return HygResponse.Success("start.....");
    }

    /**
     * 批量增加数据
     */
    @PostMapping("/volume/increase")
    public void volumeIncrease() throws InterruptedException {
        test02Service.volumeIncrease();
    }

    /**
     * 批量修改数据
     */
    @PostMapping("/bulk/changes")
    public void bulkChanges() {
        test02Service.bulkChanges();
    }

    @PostMapping("/update/moreData")
    public void updateMoreData() {
        test02Service.updateMoreData();
    }

    @PostMapping("/selectDemo")
    public void selectDemo(@RequestBody List<String> list) {
        test02Service.selectDemo(list);
    }


    @PostMapping("/test/mybatis")
    public void testMybatis() {
        test02Service.testMybatis();
    }

    @PostMapping("/test/selectCount")
    public void selectCount(@RequestParam("gender") String gender) {
        test02Service.selectCount(gender);
    }

    @PostMapping("/test/form/list")
    public void testFormList(StudentInfo studentInfo) {
        log.info("学生信息:-{}-", studentInfo);
    }


    @PostMapping("/test/view/list")
    public void testFormList(@RequestBody List<String> list) {
        log.info("集合数据:-{}-", list);

    }


}


















