package com.bridgelabz.rabbitmq.producer;

import com.bridgelabz.rabbitmq.config.MessageingConfig;
import com.bridgelabz.rabbitmq.dto.Order;
import com.bridgelabz.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order,@PathVariable String restaurantName)
    {
        order.setOrderId(UUID.randomUUID().toString() );//order service
        //restaurant service
        //payment service
        OrderStatus orderStatus=new OrderStatus(order,"PENDING","order placed successfully in "+restaurantName);
        rabbitTemplate.convertAndSend(MessageingConfig.EXCHANGE,MessageingConfig.ROUTING_KEY,orderStatus);
        return "success";
    }

}
