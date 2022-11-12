package com.gym.projetogym.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gym.projetogym.model.Musculo;

public interface MusculoRepository extends JpaRepository<Musculo, Long>{

	@Query("select m from Musculo m where m.dia.id = ?1")
	public List<Musculo> getMusculos(Long musculoid);
	
}
