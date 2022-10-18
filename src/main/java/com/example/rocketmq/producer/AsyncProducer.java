package com.example.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.text.MessageFormat;

/**
 * \* Created with WXD.
 * \* Date:  2022/10/13
 * \* Description:异步发送消息
 * \* @author 王祥栋
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception{
        //创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("group23");
        //指定Nameserv
        producer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        producer.start();
        //发送十条消息
        for (int i = 0; i < 9; i++) {
            //创建消息对象
            Message message = new Message("topic2", "tag2", ("异步发送信息" + i).getBytes());
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    //发送成功回调
                    System.out.println("发送成功....."+sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    //发送失败回调
                    System.out.println(throwable);
                }
            });
            //Thread.sleep(1000);
        }
        producer.shutdown();
    }
}
