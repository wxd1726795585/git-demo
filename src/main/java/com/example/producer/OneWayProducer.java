package com.example.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/9
 * \* Description:发送单向消息
 */
public class OneWayProducer {
    public static void main(String[] args) throws Exception{
        //1.创建消息生产者producer，并制定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //2.指定Nameserver地址
        producer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        //3.启动producer
        producer.start();
        //4.创建消息对象，指定主题Topic、Tag和消息体
        for (int i = 0; i < 10; i++) {
            //创建消息对象
            //参数一 消息主题 topic 参数二 消息tag 参数三 数据内容
            Message message = new Message("base","Tag3",("Hello Word"+i).getBytes());
            //发送单向消息
            producer.sendOneway(message);
            //线程睡眠一秒钟，再去发送
            TimeUnit.SECONDS.sleep(1);
        }

        //6.关闭生产者producer
        producer.shutdown();

    }
}
