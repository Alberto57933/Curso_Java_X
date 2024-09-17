package com.java.FinallProjectJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.FinallProjectJava.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides basic CRUD and query operations for Product
    // Extending JpaRepository defines this as a repository for Product
    // Long specifies the type of the entity's primary key
}

