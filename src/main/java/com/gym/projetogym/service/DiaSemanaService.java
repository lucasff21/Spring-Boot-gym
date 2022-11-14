package com.gym.projetogym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.projetogym.model.Dia;
import com.gym.projetogym.repository.DiaSemanaRepository;

@Service
public class DiaSemanaService {

	@Autowired
	private DiaSemanaRepository diaRepo;
	
	public List<Dia> findAll(){
		return diaRepo.findAll();
	}
	
	public Dia findById(Long id) {
		Optional<Dia> dia = diaRepo.findById(id);
		return dia.get();
	}
	
	public Dia insert(Dia dia) {
		return diaRepo.save(dia);
	}
	
	public Dia update(Long id, Dia dia) {
		Dia entity = diaRepo.getReferenceById(id);
		updateData(entity, dia);
		return diaRepo.save(entity);
	}
	
	public void updateData(Dia op1, Dia op2) {
		op1.setName(op2.getName());
	}
	
	public void delete(Long id) {
		diaRepo.deleteById(id);
	}
}
