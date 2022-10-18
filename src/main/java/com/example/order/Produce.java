package com.example.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/10/14
 * \* Description: 顺序消息的发送
 * \* @author 王祥栋
 */
public class Produce {
    public static void main(String[] args) throws Exception{
        //创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("group100");
        //指定Nameserve
        producer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        producer.start();
        //创建订单了
        List<OrderStep> orderSteps = OrderStep.buildOrders();
        for (OrderStep order:
             orderSteps) {
            //创建消息体
            Message message = new Message("topic100","tag100",order.toString().getBytes());
            //消息队列选择器
            SendResult send = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Long id = (Long) o;
                    int size = list.size();
                    int i = (int) (id % size);
                    return list.get(i);
                }
            }, order.getOrderId());
            System.out.println("发送结果..."+send);
        }
    }
}
