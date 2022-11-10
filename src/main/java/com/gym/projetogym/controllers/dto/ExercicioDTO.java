package com.gym.projetogym.controllers.dto;

import java.io.Serializable;

import com.gym.projetogym.model.Exercicio;



public class ExercicioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String observacao;
	
	
	public ExercicioDTO() {
		
	}
	
	public ExercicioDTO(Exercicio exerc) {
		this.id = exerc.getId();
		this.name = exerc.getName();
		this.observacao = exerc.getObservacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
}
