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
 * \* Date:  2022/1/9
 * \* Description:消息接收者
 */
public class Consumer {
    public static void main(String[] args) throws Exception{
        //消费者  指定组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        System.out.println("111111");
        System.out.println("222222");
        //指定nameserver地址
        consumer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        //订阅主题和tag
        consumer.subscribe("base","tag1");
        //绑定消费模式  广播模式||负载均衡模式     默认的是负载均衡模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        // 注册回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                for (MessageExt m :
                        msgs) {
                    byte[] body = m.getBody();
                    System.out.println(new String(body));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消息者
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
