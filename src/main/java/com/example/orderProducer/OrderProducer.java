package com.example.orderProducer;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.OrderStep;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/15
 * \* Description:顺序消息的生产者
 */
public class OrderProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("order");
        producer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        producer.start();
        OrderStep orderStep1 = new OrderStep();
        List<OrderStep> orderSteps = orderStep1.buildOrders();
        for (int i = 0; i < orderSteps.size(); i++) {
            OrderStep orderStep = orderSteps.get(i);
            String s = JSONObject.toJSONString(orderStep);
            Message message = new Message("OrderTopic1", "orderTag", "key" + i, s.getBytes());
            SendResult send = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Long id = (Long) o;
                    long index = id % list.size();
                    return list.get((int) index);
                }
            }, orderSteps.get(i).getOrderId());
            System.out.println("发送结果"+send);
        }
        producer.shutdown();
    }
}
