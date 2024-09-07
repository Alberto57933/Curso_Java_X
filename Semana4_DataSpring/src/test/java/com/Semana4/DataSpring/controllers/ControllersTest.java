package com.Semana4.DataSpring.controllers;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Semana4.DataSpring.models.Person;
import com.Semana4.DataSpring.repository.Repository;

public class ControllersTest {

    @Mock
    private Repository repo; // Mock repository

    @InjectMocks
    private Controllers controllers; // Controller to test

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPersons() {
        // Test data
        Person person1 = new Person(1L, "Juan", "Pérez", "555-5555", 1000);
        Person person2 = new Person(2L, "Ana", "García", "555-5556", 1200);
        List<Person> person = Arrays.asList(person1, person2);

        // Mock behavior
        when(repo.findAll()).thenReturn(person);

        // Call controller method
        List<Person> result = controllers.getPeople();

        // Verify result
        assertEquals(2, result.size());
        assertEquals("Juan", result.get(0).getName());
        assertEquals("Ana", result.get(1).getName());

        // Verify repo method call
        verify(repo).findAll();
    }

    @Test
    public void testPost() {
        // Test data
        Person person = new Person(1L, "Juan", "Pérez", "555-5555", 1000);

        // Mock behavior
        when(repo.save(any(Person.class))).thenReturn(person);

        // Call controller method
        String response = controllers.post(person);

        // Verify response
        assertEquals("Saved", response);

        // Verify repo method call
        verify(repo).save(any(Person.class));
    }

    @Test
    public void testUpdate() {
        // Test data
        Long id = 1L;
        Person existingPerson = new Person(id, "Juan", "Pérez", "555-5555", 1000);
        Person newPerson = new Person(id, "Carlos", "Lopez", "555-5557", 1500);

        // Mock behavior
        when(repo.findById(id)).thenReturn(Optional.of(existingPerson));

        // Call controller method
        String response = controllers.update(id, newPerson);

        // Verify result
        assertEquals("Updated Successfully", response);
        verify(repo).save(any(Person.class));
    }

    @Test
    public void testDelete() {
        // Test data
        Long id = 1L;
        Person person = new Person(id, "Juan", "Pérez", "555-5555", 1000);

        // Mock behavior
        when(repo.findById(id)).thenReturn(Optional.of(person));

        // Call controller method
        String response = controllers.delete(id);

        // Verify result
        assertEquals("Deleted", response);

        // Verify correct repo method call
        verify(repo).delete(person);
    }
}


