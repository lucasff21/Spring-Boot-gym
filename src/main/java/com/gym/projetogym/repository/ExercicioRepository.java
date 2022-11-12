package com.gym.projetogym.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gym.projetogym.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
 
	@Query("select e from Exercicio e where e.musculo.id = ?1")
	public List<Exercicio> getExercicios(Long exercicioid);
	
	@Query("SELECT Distinct e FROM Exercicio e INNER JOIN Musculo m ON e.musculo.id = m.id INNER JOIN DiaSemana d ON m.dia.id = ?1")
	public List<Exercicio> getExerciciosDia(Long exercid);
	
	
	
}
//("SELECT Distinct e FROM DiaSemana d INNER JOIN Musculo m ON d.id = m.dia.id INNER JOIN Exercicio e ON e.musculo.id = ?1")