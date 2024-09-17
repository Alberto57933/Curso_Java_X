package com.java.FinallProjectJava.messaging;

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
	
	public void sendOrder(CustomerOrder customerOrder)
	{
		log.info("Sending order message");
		rabbitTemplate.convertAndSend(exchange, routingKey,customerOrder);
		log.info("Order message sent");
	}
}
