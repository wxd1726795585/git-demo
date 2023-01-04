package com.example.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.CopyEntity;
import com.example.entity.StudentEntity;
import com.example.entity.TradeMqConsumerLog;
import com.example.mapper.Test02Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    /**
     * 批量修改数据
     */
    public void bulkChanges() {
        log.info("批量修改数据...");
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId("1664263309326");
        studentEntity.setName("修改数据");
        studentEntity.setAge(6666666);

        StudentEntity studentEntity02 = new StudentEntity();
        studentEntity02.setId("1664263309438");
        studentEntity02.setName("修改数据");
        studentEntity02.setAge(6666666);

        List<StudentEntity> list=new ArrayList<>();
        list.add(studentEntity);
        list.add(studentEntity02);

        int row=test02Mapper.bulkChanges(list);
        log.info("总共修改了-{}-条",row);



    }

    public void updateMoreData() {
        ArrayList<TradeMqConsumerLog> tradeMqConsumerLogs = new ArrayList<>();
        TradeMqConsumerLog tradeMqConsumerLog = new TradeMqConsumerLog();
        tradeMqConsumerLog.setGroupName("1");
        tradeMqConsumerLog.setMsgKey("1");
        tradeMqConsumerLog.setMsgTag("1");
        tradeMqConsumerLog.setRemark("一");
        tradeMqConsumerLog.setConsumerTimes(1);



        TradeMqConsumerLog tradeMqConsumerLog1 = new TradeMqConsumerLog();
        tradeMqConsumerLog1.setGroupName("2");
        tradeMqConsumerLog1.setMsgKey("2");
        tradeMqConsumerLog1.setMsgTag("2");
        tradeMqConsumerLog1.setRemark("二");
        tradeMqConsumerLog1.setConsumerTimes(2);


        TradeMqConsumerLog tradeMqConsumerLog2 = new TradeMqConsumerLog();
        tradeMqConsumerLog2.setGroupName("3");
        tradeMqConsumerLog2.setMsgKey("3");
        tradeMqConsumerLog2.setMsgTag("3");
        tradeMqConsumerLog2.setRemark("三");
        tradeMqConsumerLog2.setConsumerTimes(3);

        tradeMqConsumerLogs.add(tradeMqConsumerLog);
        tradeMqConsumerLogs.add(tradeMqConsumerLog1);
        tradeMqConsumerLogs.add(tradeMqConsumerLog2);


        tradeMqConsumerLogs.forEach(x->{
            x.setLid(x.getGroupName().concat(x.getMsgKey()).concat(x.getMsgTag()));
        });
        int i=test02Mapper.updateMoreData(tradeMqConsumerLogs);
        log.info("总共修改了:{}条数据",i);
    }

    public void selectDemo(List<String> id) {
        BigDecimal bigDecimal=test02Mapper.selectDemo(id);
        System.out.println(bigDecimal);
    }

    /**
     * 测试mybatis
     */
    public void testMybatis() {
        //测试demo 分支 测试
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gender","女");
        String age="14";
        List<CopyEntity> list=test02Mapper.testMybatis(jsonObject,age);
        System.out.println(list);
    }

    /**
     * 查询测试
     */
    public void selectCount(String gender) {
        Integer count = test02Mapper.selectCount(gender);
        log.info("个数-{}-",count);
    }
}
