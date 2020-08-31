package com.demo.common.query.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** rabbitmq 连接类
 * @author HuTing
 * @date 2020-08-20 11:30
 */
public class MQConnectionUtils {
    public static Connection newConnection() throws IOException, TimeoutException {
        /** 1.定义连接工厂 */
        ConnectionFactory factory = new ConnectionFactory();
        /** 2.设置服务器地址 */
        factory.setHost("127.0.0.1");
        /** 3.设置协议端口号 */
        factory.setPort(5672);
        /** 4.设置vhost */
        factory.setVirtualHost("test001_host");
        /** 5.设置用户名称 */
        factory.setUsername("admin");
        /** 6.设置用户密码 */
        factory.setPassword("admin");
        /** 7.创建新的连接 */
        Connection newConnection = factory.newConnection();
        return newConnection;
    }
}
