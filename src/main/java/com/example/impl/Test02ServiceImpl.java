package com.example.impl;

import com.example.entity.StudentEntity;
import com.example.mapper.Test02Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void volumeIncrease() {
        log.info("批量增加数据.....");
        List<StudentEntity> studentEntities = test02Mapper.selectAllStudents();
        System.out.println(studentEntities);
    }
}
