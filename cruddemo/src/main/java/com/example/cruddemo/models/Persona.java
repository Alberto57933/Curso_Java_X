package com.example.cruddemo.models;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
public class Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Getter
	@Setter
	private long id;
	
	@Column
	@Getter
	@Setter
	private String nombre;
	
	@Column(name="tel")
	@Getter
	@Setter
	private String telefono;
}
