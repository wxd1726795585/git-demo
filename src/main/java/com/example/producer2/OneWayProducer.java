package com.example.producer2;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/10
 * \* Description:这种场景不需要关心发送的场景 例如：日志的发送
 */
public class OneWayProducer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("group6");
        producer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base", "tag6", ("坚持加油" + i).getBytes());
            producer.sendOneway(message);
            TimeUnit.SECONDS.sleep(1);

        }
        producer.shutdown();
    }
}
