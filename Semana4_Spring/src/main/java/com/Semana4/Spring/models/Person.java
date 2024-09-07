package com.Semana4.Spring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Person {

    // Primary key
    @Id
    // Auto-generated primary key (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Lombok auto-generates getters and setters
    @Getter @Setter
    private long id;

    // Maps to table column
    @Column
    @Getter @Setter
    private String name;
    
    @Column
    @Getter @Setter
    private String lastName;

    @Column
    @Getter @Setter
    private String phone;

    @Column
    @Getter @Setter
    private int salary;
}

