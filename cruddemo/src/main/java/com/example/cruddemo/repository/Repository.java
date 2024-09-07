package com.example.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruddemo.models.Persona;

public interface Repository extends JpaRepository<Persona, Long> {

}
