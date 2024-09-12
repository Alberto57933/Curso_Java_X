package com.java.FinallProjectJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.FinallProjectJava.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
