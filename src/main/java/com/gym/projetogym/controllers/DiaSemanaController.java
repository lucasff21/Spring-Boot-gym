package com.gym.projetogym.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gym.projetogym.model.DiaSemana;
import com.gym.projetogym.service.DiaSemanaService;

@RestController
@RequestMapping(value = "/api/diasemana")
public class DiaSemanaController {

	@Autowired
	private DiaSemanaService diaServ;
	
	@GetMapping
	public ResponseEntity<List<DiaSemana>> getDias(){
		List<DiaSemana> dias = diaServ.findAll();
		return ResponseEntity.ok().body(dias);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DiaSemana> getById(@PathVariable Long id){
		DiaSemana diaId = diaServ.findById(id);
		return ResponseEntity.ok().body(diaId);
	}
	
	@PostMapping
	public ResponseEntity<DiaSemana> createDia(@RequestBody DiaSemana diaCreate){
		diaCreate = diaServ.insert(diaCreate);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(diaCreate.getId()).toUri();
		return ResponseEntity.created(uri).body(diaCreate);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DiaSemana> updateDia(@PathVariable Long id, @RequestBody DiaSemana diaCreate){
		diaCreate = diaServ.update(id, diaCreate);
		return ResponseEntity.ok().body(diaCreate);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDia(@PathVariable Long id){
		diaServ.delete(id);
		return ResponseEntity.noContent().build();
	}
}
