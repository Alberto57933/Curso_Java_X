package com.java.FinallProjectJava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.FinallProjectJava.Rabbit.OrderMessageSender;
import com.java.FinallProjectJava.entity.CustomerOrder;
import com.java.FinallProjectJava.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    // Injects services and message sender
    private final OrderService orderService;
    private final OrderMessageSender messageSender;

    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        // Returns all customer orders
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getOrderById(@PathVariable Long id) {
        // Retrieves order by ID, handles not found
        Optional<CustomerOrder> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomerOrder createOrder(@RequestBody CustomerOrder customerOrder) {
        // Saves a new customer order
        CustomerOrder savedOrder = orderService.saveOrder(customerOrder);

        try {
            // Sends order to RabbitMQ
            messageSender.sendOrder(savedOrder);
        } catch (Exception e) {
            // Logs error if RabbitMQ fails
            log.error("Failed to send order to RabbitMQ", e);
        }

        return savedOrder;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        // Deletes order by ID
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

