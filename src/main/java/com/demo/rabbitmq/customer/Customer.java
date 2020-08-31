package com.demo.rabbitmq.customer;

import com.demo.common.query.utils.MQConnectionUtils;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author HuTing
 * @date 2020-08-20 11:39
 */
public class Customer {
    private final Logger logger = LoggerFactory.getLogger(Customer.class);

    /** 队列名称 */
    private static final String QUEUE_NAME = "test_queue";

    public static void main(String[] args) {
        System.out.println("002");
        try {
            /** 1.获取连接 */
            Connection newConnection = MQConnectionUtils.newConnection();
            /** 2.获取通道 */
            Channel channel = newConnection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body){
                    String msgString = new String(body, StandardCharsets.UTF_8);
                    System.out.println("消费者获取消息:" + msgString);
                }
            };
            /** 3.监听队列 */
            channel.basicConsume(QUEUE_NAME, true, defaultConsumer);
        } catch (IOException | TimeoutException e) {
//            logger.error(ExceptionUtil.getStackMsg(e));
        }
    }
}
