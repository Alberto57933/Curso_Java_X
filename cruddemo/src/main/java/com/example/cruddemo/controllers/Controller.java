package com.example.cruddemo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddemo.models.Persona;
import com.example.cruddemo.repository.Repository;

@RestController
public class Controller {
	
	@Autowired
	private Repository repo;
	
	@GetMapping()
	public String index() {
		return "CONECTADO";
	}
	
	@GetMapping("personas")
	public List<Persona> getPersona()
	{
		return repo.findAll();
	}
	
	@PostMapping("grabar")
	public String post(@RequestBody Persona persona) {
		repo.save(persona);
		return "Grabado";
	}
	
	@PutMapping("editar/{id}")
	public String update(@PathVariable Long id, @RequestBody Persona persona)
	{
		Persona updatePersona = repo.findById(id).get();
		updatePersona.setNombre(persona.getNombre());
		updatePersona.setTelefono(persona.getTelefono());
		repo.save(updatePersona);
		return "Editado Correctamente";
	}
	
	@DeleteMapping("delete/{}id")
	public String delete(@PathVariable Long id) {
		Persona deletePerona = repo.findById(id).get();
		repo.delete(deletePerona);
		return "Eliminado";
	}

}
