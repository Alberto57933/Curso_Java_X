package com.java.FinallProjectJava.Rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.java.FinallProjectJava.entity.CustomerOrder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderMessageSender {

    // Injects RabbitTemplate for message sending
    private final RabbitTemplate rabbitTemplate;

    // Routing key, loaded from properties
    @Value("${order.routingkey}")
    private String routingKey;

    // Exchange name, loaded from properties
    @Value("${order.exchange}")
    private String exchange;

    public void sendOrder(CustomerOrder order) {
        // Logs and sends order to RabbitMQ
        log.info("Sending order message: {}", order);
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
        log.info("Order message sent: {}", order);
    }
}
