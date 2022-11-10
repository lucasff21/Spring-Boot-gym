package com.gym.projetogym.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.gym.projetogym.controllers.dto.ExercicioDTO;
import com.gym.projetogym.model.Exercicio;
import com.gym.projetogym.service.ExercicioService;

@RestController
@RequestMapping(value  = "/api/exercicio")
public class ExercicioController {

	@Autowired
	private ExercicioService service;
	
	@PostMapping
	public ResponseEntity<Exercicio> createExercicio(@RequestBody Exercicio exerc) {
		exerc = service.createExercicio(exerc);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(exerc.getId()).toUri();
		return ResponseEntity.created(uri).body(exerc);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ExercicioDTO>> getAllExercicio(){
		List<Exercicio> list = service.findAll();
		List<ExercicioDTO> listDTO = list.stream().map(x -> new ExercicioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Exercicio> getById(@PathVariable Long id){
		Exercicio exerc = service.findById(id);
		return ResponseEntity.ok().body(exerc);
	}
	
	@PutMapping(value = "/{id}" )
	public ResponseEntity<Exercicio> updateExercicio(@PathVariable Long id, @RequestBody Exercicio exerc){
		exerc = service.updateExercicio(id, exerc);
		return ResponseEntity.ok().body(exerc);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteExercicio(@PathVariable Long id) {
		service.deleteExercicio(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
