package com.example.producer3;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/15
 * \* Description:
 */
public class SyncProducer3 {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("group888");
        producer.setNamesrvAddr("192.168.2.130:9876;192.168.2.131:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("Base", "tag888", ("坚持加油" + i).getBytes());
            SendResult send = producer.send(message);
            System.out.println(send);
        }
        producer.shutdown();
    }
}
