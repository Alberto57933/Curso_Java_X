package com.java.FinallProjectJava.Rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.java.FinallProjectJava.entity.CustomerOrder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderMessageListener {

    @RabbitListener(queues = "${order.queue}")
    public void receiveOrder(CustomerOrder order) {
        log.info("Received order message: {}", order);
    }
}
