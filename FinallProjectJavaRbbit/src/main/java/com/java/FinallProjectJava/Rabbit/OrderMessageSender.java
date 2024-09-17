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

    private final RabbitTemplate rabbitTemplate;

    @Value("${order.routingkey}")
    private String routingKey;

    @Value("${order.exchange}")
    private String exchange;

    public void sendOrder(CustomerOrder order) {
        log.info("Sending order message: {}", order);
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
        log.info("Order message sent: {}", order);
    }
}