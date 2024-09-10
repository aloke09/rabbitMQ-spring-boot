package com.bridgelabz.rabbitmq.consumer;

import com.bridgelabz.rabbitmq.config.MessageingConfig;
import com.bridgelabz.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User
{
    @RabbitListener(queues = MessageingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus)
    {
        System.out.println("Message received from queue "+orderStatus);
    }
}
