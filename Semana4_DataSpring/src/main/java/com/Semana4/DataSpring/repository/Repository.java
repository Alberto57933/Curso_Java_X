package com.Semana4.DataSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Semana4.DataSpring.models.Person;

//Esta interfaz define un repositorio para la entidad 'Persona'.
//Extiende JpaRepository, lo que le proporciona métodos CRUD básicos y más funcionalidades.
public interface Repository extends JpaRepository<Person, Long> {
	
}
