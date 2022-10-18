package com.example.order;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/10/14
 * \* Description:顺序消费的消费者
 * \* @author 王祥栋
 */
@Slf4j
public class Consumer {
    public static void main(String[] args) throws Exception{
        //创建消费者
        DefaultMQPushConsumer group = new DefaultMQPushConsumer("group100");
        //指定Nameserve
        group.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        //订阅消息  topic  tag
        group.subscribe("topic100","*");
        //注册监听(顺序的)
        group.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt message:
                     list) {
                    System.out.println("线程名称:"+Thread.currentThread().getName()+"所消费的内容"+new String(message.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        String str="a";
        String str1="v";
        System.out.println(str==str1);
        //注册监听(无序的)
       /* group.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt message:
                        list) {
                    System.out.println("线程名称:"+Thread.currentThread().getName()+"所消费的内容"+new String(message.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });*/
        group.start();
        log.info("开始启动消费者....");
    }
}
