package com.example.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/15
 * \* Description:
 */
public class Consumer2 {
    public static void main(String[] args) throws Exception{
        //1.创建消费者Consumer，制定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        //2.指定Nameserver地址
        consumer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        //3.订阅主题Topic和Tag
        consumer.subscribe("base","tag1");
        //绑定消费模式  广播模式||负载均衡模式     默认的是负载均衡模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        //4.设置回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt:
                     list) {
                    byte[] body = messageExt.getBody();
                    System.out.println(new String(body));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //5.启动消费者consumer
        consumer.start();
    }
}
