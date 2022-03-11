package com.example.producer2;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/10
 * \* Description:手动练习同步消息生产者的发送
 */
public class SyncProducer2 {
    public static void main(String[] args) throws Exception{
        /*1.创建消息生产者producer，并制定生产者组名
        2.指定Nameserver地址
        3.启动producer
        4.创建消息对象，指定主题Topic、Tag和消息体
        5.发送消息
        6.关闭生产者producer*/
        DefaultMQProducer producer = new DefaultMQProducer("group6");
        producer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base", "tag6", ("坚持加油" + i).getBytes());
            SendResult send = producer.send(message);
            System.out.println("输出结果"+send);
            //线程睡眠1S执行
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
