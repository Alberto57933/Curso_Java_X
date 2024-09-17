package com.java.FinallProjectJava.Rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Queue name, loaded from properties
    @Value("${order.queue}")
    private String queueName;

    // Exchange name, loaded from properties
    @Value("${order.exchange}")
    private String exchangeName;

    // Routing key, loaded from properties
    @Value("${order.routingkey}")
    private String routingKey;

    @Bean
    public Queue queue() {
        // Defines a durable RabbitMQ queue
        return new Queue(queueName, true);
    }

    @Bean
    public TopicExchange exchange() {
        // Defines a RabbitMQ topic exchange
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        // Binds the queue to the exchange using the routing key
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        // Configures a JSON message converter for RabbitMQ
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        // Configures RabbitTemplate with JSON message converter
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}

