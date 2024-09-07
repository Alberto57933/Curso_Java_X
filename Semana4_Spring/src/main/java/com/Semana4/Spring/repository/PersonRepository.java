package com.Semana4.Spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.Semana4.Spring.models.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Get all people
    public List<Person> findAll() {
        String jpql = "SELECT p FROM Person p";
        return entityManager.createQuery(jpql, Person.class).getResultList();
    }

    // Save or update person
    @Transactional
    public Person save(Person person) {
        if (person.getId() == 0) {
            entityManager.persist(person); // New record
        } else {
            entityManager.merge(person); // Update
        }
        return person;
    }

    // Find person by ID
    public Optional<Person> findById(Long id) {
        Person person = entityManager.find(Person.class, id);
        return person != null ? Optional.of(person) : Optional.empty();
    }

    // Delete person
    @Transactional
    public void delete(Person person) {
        if (entityManager.contains(person)) {
            entityManager.remove(person); // Direct removal
        } else {
            Person managedPerson = entityManager.find(Person.class, person.getId());
            if (managedPerson != null) {
                entityManager.remove(managedPerson);
            }
        }
    }
}


