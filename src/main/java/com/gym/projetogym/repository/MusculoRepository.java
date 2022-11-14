package com.gym.projetogym.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gym.projetogym.model.Musculo;

public interface MusculoRepository extends JpaRepository<Musculo, Long>{

	//@Query("Select Distinct m from Musculo m INNER JOIN tb.musculo.dia t ON m.id = t.musculo.id INNER JOIN Dia d ON d.id = t.dia_id WHERE t.dia.id = ?1")
	@Query("select m from Musculo m inner join m.dias d where d.id = ?1 ")
	public List<Musculo> getMusculos(Long id);
	
}
