package com.slandshow.helpers;

import com.rabbitmq.client.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Listener {
/*
    private static final String EXCHANGE_NAME = "messages";
    private static final Logger log = Logger.getLogger(Listener.class);
    private Channel channel;
    private Connection connection;
    private DataManager dataManager = DataManager.getInstance();

    public void start() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connection = connectionFactory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(EXCHANGE_NAME, false, false, false, null);
        System.out.println("Receive message");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                log.info(" [x] Received '" + message + "'");
                if (message.contains("create") || message.contains("delete") || message.contains("update")) {
                    log.info(message);
                    dataManager.changeState(message);
                }
            }
        };
        channel.basicConsume(EXCHANGE_NAME, true, consumer);
    }

    public void stop() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
*/
}

