package com.java.FinallProjectJava.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.java.FinallProjectJava.entity.CustomerOrder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderMessageListener {

    @RabbitListener(queues = "${order.queue}")
    public void receiveMessage(String message) {
        // Imprimir el mensaje recibido como String
        log.info("Received message as String: {}", message);
    }
}
