package com.java.FinallProjectJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.FinallProjectJava.entity.CustomerOrder;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    // JpaRepository provides basic CRUD and query operations for CustomerOrder
    // Extending JpaRepository defines this as a repository for CustomerOrder
    // Long specifies the type of the entity's primary key
}

