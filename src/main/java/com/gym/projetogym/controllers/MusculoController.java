package com.gym.projetogym.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.projetogym.model.Musculo;
import com.gym.projetogym.repository.MusculoRepository;



@RestController
@RequestMapping("/api/musculo")
public class MusculoController {

	@Autowired
	private MusculoRepository musculoRepo;

	@GetMapping
	public ResponseEntity<List<Musculo>> findAll() {
		List<Musculo> musculo = new ArrayList<>();
		musculo = musculoRepo.findAll();
		return new ResponseEntity<>(musculo, HttpStatus.OK);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Musculo> findById(@PathVariable Long id) {
		Optional<Musculo> musculoBuscar = musculoRepo.findById(id);
		if(musculoBuscar.isPresent()) {
			return new ResponseEntity<>(musculoBuscar.get(), HttpStatus.OK);
		}else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }	
	}

	@PostMapping
	public ResponseEntity<Musculo> insert(@RequestBody Musculo musculo) {
		musculo = musculoRepo.save(musculo);
		return ResponseEntity.ok().body(musculo);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Musculo> update(@PathVariable Long id, @RequestBody Musculo musculo) {
		Optional<Musculo> musculoUpdate = musculoRepo.findById(id);
		
		if (musculoUpdate.isPresent()) {
			Musculo _musculo = musculoUpdate.get();
			_musculo.setName(musculo.getName());
			_musculo.setDescricao(musculo.getDescricao());
			return new ResponseEntity<>(musculoRepo.save(_musculo), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		try {
			musculoRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		
	}
}
