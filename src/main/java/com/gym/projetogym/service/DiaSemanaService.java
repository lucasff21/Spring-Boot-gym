package com.gym.projetogym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.projetogym.model.DiaSemana;
import com.gym.projetogym.repository.DiaSemanaRepository;

@Service
public class DiaSemanaService {

	@Autowired
	private DiaSemanaRepository diaRepo;
	
	public List<DiaSemana> findAll(){
		return diaRepo.findAll();
	}
	
	public DiaSemana findById(Long id) {
		Optional<DiaSemana> dia = diaRepo.findById(id);
		return dia.get();
	}
	
	public DiaSemana insert(DiaSemana dia) {
		return diaRepo.save(dia);
	}
	
	public DiaSemana update(Long id, DiaSemana dia) {
		DiaSemana entity = diaRepo.getReferenceById(id);
		updateData(entity, dia);
		return diaRepo.save(entity);
	}
	
	public void updateData(DiaSemana op1, DiaSemana op2) {
		op1.setDiaSemana(op2.getDiaSemana());
	}
	
	public void delete(Long id) {
		diaRepo.deleteById(id);
	}
}
