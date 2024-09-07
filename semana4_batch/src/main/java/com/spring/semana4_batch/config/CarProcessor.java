package com.spring.semana4_batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.spring.semana4_batch.entity.Car;

public class CarProcessor implements ItemProcessor<Car,Car> {

	@Override
	public Car process(Car car) throws Exception {
		// TODO Auto-generated method stub
		return car;
	}

}
