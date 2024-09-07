package com.spring.semana4_batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.semana4_batch.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
