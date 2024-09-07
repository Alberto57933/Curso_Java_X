package com.Semana4.DataSpring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Semana4.DataSpring.models.Person;
import com.Semana4.DataSpring.repository.Repository;

@RestController
public class Controllers {

    @Autowired
    private Repository repo;

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

    // Save new person
    @PostMapping("save")
    public String post(@RequestBody Person person) {
        repo.save(person);
        return "Saved";
    }

    // Update existing person
    @PutMapping("update/{id}")
    public String update(@PathVariable Long id, @RequestBody Person person) {
        // Find person by id
        Person updatePerson = repo.findById(id).get();
        // Update person details
        updatePerson.setName(person.getName());
        updatePerson.setNumber(person.getNumber());
        updatePerson.setLast_name(person.getLast_name());
        updatePerson.setSalary(person.getSalary());
        // Save changes
        repo.save(updatePerson);
        return "Updated Successfully";
    }

    // Delete person by id
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        // Find person by id
        Person deletePerson = repo.findById(id).get();
        // Delete person
        repo.delete(deletePerson);
        return "Deleted";
    }
}

