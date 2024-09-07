package com.Semana4.DataSpring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor // No-args constructor (JPA required)
@AllArgsConstructor // All-args constructor
public class Person {

    // Primary key
    @Id
    // Auto-generate primary key (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Lombok generates getters and setters for "id"
    @Getter @Setter
    private long id;

    // Maps to table column
    @Column
    @Getter @Setter
    private String name;
    
    @Column
    @Getter @Setter
    private String last_name;

    @Column
    @Getter @Setter
    private String number;

    @Column
    @Getter @Setter
    private int salary;
}
