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
	private final OrderRepository orderRepository;
	
	public List<CustomerOrder> getAllOrders()
	{
		return orderRepository.findAll();
	}
	
	public Optional<CustomerOrder> getOrderById(Long id)
	{
		return orderRepository.findById(id);
	}
	
	public CustomerOrder saveOrder(CustomerOrder customerOrder)
	{
		log.info("Saving order for customer");
		// Asociar cada producto con la orden
        List<Product> products = customerOrder.getProducts();
        if (products != null) {
            for (Product product : products) {
                log.info("Associating product {} with order {}", product.getName(), customerOrder.getCustomerName());
                product.setCustomerOrder(customerOrder);  // Establece la relación
            }
        } else {
            log.warn("No products found in the order");
        }

        // Guardar la orden
        CustomerOrder savedOrder = orderRepository.save(customerOrder);
        log.info("Order saved with ID and products");
        return savedOrder;
	}
	
	public void deleteOrder(Long id)
	{
		orderRepository.deleteById(id);
	}
}
