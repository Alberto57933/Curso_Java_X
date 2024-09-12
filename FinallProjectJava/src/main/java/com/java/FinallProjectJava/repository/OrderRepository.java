package com.java.FinallProjectJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.FinallProjectJava.entity.CustomerOrder;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long>{

}
