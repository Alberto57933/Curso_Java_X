package com.java.FinallProjectJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.FinallProjectJava.entity.CustomerOrder;
import com.java.FinallProjectJava.entity.Product;
import com.java.FinallProjectJava.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    // Injects the OrderRepository for database access
    private final OrderRepository orderRepository;

    public List<CustomerOrder> getAllOrders() {
        // Fetches all customer orders from the database
        return orderRepository.findAll();
    }

    public Optional<CustomerOrder> getOrderById(Long id) {
        // Fetches a specific customer order by its ID
        return orderRepository.findById(id);
    }

    public CustomerOrder saveOrder(CustomerOrder customerOrder) {
        // Logs the process of saving the order
        log.info("Saving order for customer: {}", customerOrder.getCustomerName());

        // Associates products with the order if they exist
        List<Product> products = customerOrder.getProducts();
        if (products != null) {
            log.info("Products before association: {}", products);
            for (Product product : products) {
                // Associates each product with the order
                log.info("Associating product {} with order {}", product.getName(), customerOrder.getCustomerName());
                product.setCustomerOrder(customerOrder);
            }
        } else {
            // Logs a warning if no products are found
            log.warn("No products found in the order");
        }

        // Saves the order and returns the saved instance
        CustomerOrder savedOrder = orderRepository.save(customerOrder);
        return savedOrder;
    }

    public void deleteOrder(Long id) {
        // Deletes a specific order by its ID
        orderRepository.deleteById(id);
    }
}

