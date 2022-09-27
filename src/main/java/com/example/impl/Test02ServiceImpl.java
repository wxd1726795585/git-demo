package com.example.impl;

import com.example.entity.StudentEntity;
import com.example.mapper.Test02Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/27
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
@Service
public class Test02ServiceImpl {
    @Autowired
    private Test02Mapper test02Mapper;
    /**
     * 批量增加数据
     */
    public void volumeIncrease() throws InterruptedException {
        log.info("批量增加数据.....");
        List<StudentEntity> list = new ArrayList<>();

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAge(1);
        studentEntity.setId(String.valueOf(System.currentTimeMillis()));
        studentEntity.setIdCard("测试");
        studentEntity.setName("测试");
        Thread.sleep(100);
        StudentEntity studentEntity2 = new StudentEntity();
        studentEntity2.setAge(1);
        studentEntity2.setId(String.valueOf(System.currentTimeMillis()));
        studentEntity2.setIdCard("测试");
        studentEntity2.setName("测试");

        list.add(studentEntity);
        list.add(studentEntity2);

        int row=test02Mapper.volumeIncrease(list);
        log.info("总共增加了-{}-条",row);

    }
}
