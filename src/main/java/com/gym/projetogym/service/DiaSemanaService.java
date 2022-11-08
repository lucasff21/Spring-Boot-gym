package com.gym.projetogym.service;

import java.util.List;

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
	
}
