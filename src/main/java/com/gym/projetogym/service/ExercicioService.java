package com.gym.projetogym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.projetogym.model.Exercicio;
import com.gym.projetogym.repository.ExercicioRepository;

@Service
public class ExercicioService {

	@Autowired
	private ExercicioRepository exercicioRepo;
	
	public List<Exercicio> findAll(){
		return exercicioRepo.findAll();
	}
	
	public Exercicio findById(Long id){
		Optional<Exercicio> exercicio = exercicioRepo.findById(id);
		return exercicio.get();
	}
	
	public Exercicio createExercicio(Exercicio exerc) {
		return exercicioRepo.save(exerc);
	}
	
	public void deleteExercicio(Long id) {
		exercicioRepo.deleteById(id);
	}
	
	public Exercicio updateExercicio(Long id, Exercicio exercicio) {
		Exercicio exerc = exercicioRepo.findById(id).get();
		exerc.setMusculo(exercicio.getMusculo());
		exerc.setName(exercicio.getName());
		exerc.setObservacao(exercicio.getObservacao());
		exerc.setRepeticao(exercicio.getRepeticao());
		exerc.setSerie(exercicio.getSerie());
		
		return exercicioRepo.save(exerc);
	}
	
}
