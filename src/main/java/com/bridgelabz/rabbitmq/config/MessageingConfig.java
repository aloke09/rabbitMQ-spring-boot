package com.bridgelabz.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageingConfig
{
    public static final String QUEUE="javaTechiq_queue";
    public static final String EXCHANGE="javaTechiq_exchange";
    public static final String ROUTING_KEY="javaTechiq_routingkey";


    @Bean
    public Queue queue()//queue created;
    {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange topicExchange()
    {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue,TopicExchange exchange)
    {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory)
    {
        //The ConnectionFactory manages connections to the RabbitMQ server.
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //A RabbitTemplate is instantiated using the provided ConnectionFactory. The RabbitTemplate is a
        // core class in Spring AMQP used for sending and receiving messages to/from RabbitMQ.
        rabbitTemplate.setMessageConverter(converter());
        //This line sets a custom message converter using converter().
        //By setting a message converter, you're configuring how the
        // messages sent to and from RabbitMQ are serialized or deserialized.
        return rabbitTemplate;
    }
}
