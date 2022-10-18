package com.example.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

/**
 * \* Created with WXD.
 * \* Date:  2022/10/13
 * \* Description:发送同步消息
 * \* @author 王祥栋
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //指定生产者 并且指定组名
        DefaultMQProducer group1 = new DefaultMQProducer("group1");
        //指定NameServe
        group1.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        //启动生产者
        group1.start();
        //循环发送十次
        for (int i = 0; i <10 ; i++) {
            Message message = new Message("test", "test", ("测试内容" + i).getBytes());
            SendResult send = group1.send(message);
            SendStatus sendStatus = send.getSendStatus();
            System.out.println("发送状态"+send);
        }
        group1.shutdown();
    }
}
