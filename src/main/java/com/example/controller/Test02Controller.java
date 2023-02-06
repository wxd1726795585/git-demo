package com.example.controller;

import com.example.bean.GeShi;
import com.example.impl.Test02ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public void bulkChanges(){
        test02Service.bulkChanges();
    }
    @PostMapping("/update/moreData")
    public void updateMoreData(){
        test02Service.updateMoreData();
    }

    @PostMapping("/selectDemo")
    public void selectDemo(@RequestBody List<String> list){
        test02Service.selectDemo(list);
    }


    @PostMapping("/test/mybatis")
    public void testMybatis(){
        test02Service.testMybatis();
    }

    @PostMapping("/test/selectCount")
    public void selectCount(@RequestParam("gender")String gender){
        test02Service.selectCount(gender);
    }


    @PostMapping("/test/geShi")
    public String testGeShi(@RequestBody @Valid GeShi geShi , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String defaultMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            log.info(defaultMessage);
            return defaultMessage;
        }
        return geShi.toString();
    }






}


















