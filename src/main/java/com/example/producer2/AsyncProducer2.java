package com.example.producer2;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/10
 * \* Description:手动练习发送异步消息生产者
 */
public class AsyncProducer2 {
    public static void main(String[] args) throws Exception{
        //创建生产者并且指定组名
        DefaultMQProducer producer = new DefaultMQProducer("group6");
        //指定nameserver
        producer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        //启动producer
        producer.start();
        //发送消息
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base", "tag6", ("祥栋最棒" + i).getBytes());
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("发送结果"+sendResult);
                }

                @Override
                public void onException(Throwable throwable) {

                }
            });
            TimeUnit.SECONDS.sleep(1);
        }
        producer.shutdown();
    }
}
