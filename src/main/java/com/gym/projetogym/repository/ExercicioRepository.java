package com.gym.projetogym.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gym.projetogym.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
 
	@Query("select e from Exercicio e where e.musculo.id = ?1")
	public List<Exercicio> getExercicios(Long exercicioid);
	
	@Query("Select distinct e from Exercicio e "
			+ " INNER JOIN Musculo m ON e.musculo.id = m.id"
			+ " INNER JOIN m.dias d ON d.id = ?1 ")
	public List<Exercicio> getExerciciosDia(Long exercid);
	
	
	
}
//Select distinct e.* from Exercicio e 
//INNER JOIN Musculo m ON e.musculo_id = m.id 
//INNER JOIN tb_musculo_dia tmd ON m.id = tmd.musculo_id 
//INNER JOIN Dia d ON tmd.dia_id = d.id 
//WHERE tmd.dia_id = 6