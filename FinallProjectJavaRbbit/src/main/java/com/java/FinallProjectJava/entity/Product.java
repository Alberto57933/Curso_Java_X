package com.java.FinallProjectJava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Marks this class as a JPA entity
@Data // Lombok: generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok: generates a no-arguments constructor
public class Product { // Represents a product entity

	@Id // Marks this field as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID values
	private Long id; // Unique identifier for the product
	
	private String name; // Product name
	
	private String description; // Product description
	
	private double price; // Product price
	
	@ManyToOne(fetch = FetchType.LAZY) // Many products can be associated with one order
	@JoinColumn(name ="order_id", nullable =false) // Maps the foreign key to the order
	@JsonIgnore // Prevents circular references during JSON serialization
	private CustomerOrder customerOrder; // The associated order for this product
}

