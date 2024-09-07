package com.spring.semana4_batch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CUSTOMERS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	@Id
	@Column(name = "CAR_ID")
	private int id;
	
	@Column(name= "CAR_MAKE")
	private String car_make;
	
	@Column(name= "CAR_MODEL")
	private String car_model;
	
	@Column(name= "CAR_YEAR")
	private int car_year;
	
	@Column(name= "CAR_VIN")
	private String car_vin;
	
	
}
