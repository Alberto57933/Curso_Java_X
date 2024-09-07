package com.Semana4.Spring.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Semana4.Spring.models.Person;
import com.Semana4.Spring.repository.PersonRepository;

@RestController
public class Controllers {

    @Autowired
    private PersonRepository repo;

    // Check connection
    @GetMapping()
    public String index() {
        return "CONNECTED";
    }

    // Get all people
    @GetMapping("people")
    public List<Person> getPeople() {
        return repo.findAll();
    }

    // Save a new person
    @PostMapping("save")
    public String post(@RequestBody Person person) {
        repo.save(person);
        return "Saved";
    }

    // Update existing person
    @PutMapping("update/{id}")
    public String update(@PathVariable Long id, @RequestBody Person person) {
        // Find person by ID
        Optional<Person> optionalPerson = repo.findById(id);
        if (optionalPerson.isPresent()) {
            // Update person details
            Person updatePerson = optionalPerson.get();
            updatePerson.setName(person.getName());
            updatePerson.setPhone(person.getPhone());
            updatePerson.setLastName(person.getLastName());
            updatePerson.setSalary(person.getSalary());
            // Save updated person
            repo.save(updatePerson);
            return "Updated Successfully";
        } else {
            return "Person not found";
        }
    }

    // Delete person by ID
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        // Find person by ID
        Optional<Person> optionalPerson = repo.findById(id);
        if (optionalPerson.isPresent()) {
            // Delete person
            repo.delete(optionalPerson.get());
            return "Deleted";
        } else {
            return "Person not found";
        }
    }
}



