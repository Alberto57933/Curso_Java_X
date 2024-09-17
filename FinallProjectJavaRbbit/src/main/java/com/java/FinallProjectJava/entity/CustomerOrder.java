package com.java.FinallProjectJava.entity;

import java.io.Serializable;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Marks this class as a JPA entity
@Data // Lombok: generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok: generates a no-arguments constructor
public class CustomerOrder implements Serializable { // Implements Serializable for message conversion

	private static final long serialVersionUID = 1L; // Ensures compatibility during serialization

	@Id // Marks this field as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID values
	private Long id; // Unique identifier for the order
	
	@NotNull // Ensures this field cannot be null
	private String customerName; // Customer's name
	
	private String orderDate; // Date when the order was placed
	
	@OneToMany(mappedBy = "customerOrder", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	// OneToMany relationship: an order can have multiple products
	@ToString.Exclude // Excludes products from toString() to avoid circular reference
	private List<Product> products; // List of products associated with this order
}

