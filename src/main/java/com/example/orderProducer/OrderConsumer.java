package com.example.orderProducer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/15
 * \* Description:订单消费者 顺序消费
 */
public class OrderConsumer {
    public static void main(String[] args) throws Exception{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order");
        consumer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        consumer.subscribe("OrderTopic1","*");
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt messageExt:
                     list) {
                    System.out.println("线程名称执行:"+Thread.currentThread().getName()+"-消费信息为"+new String(messageExt.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.out.println("订单消费者启动...");
    }
}
