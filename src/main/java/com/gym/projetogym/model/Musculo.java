package com.gym.projetogym.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Musculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String observacao;
	
	@OneToMany(mappedBy = "musculo")
	private List<Exercicio> exercicio = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "dia_id")
	@JsonIgnore
	private DiaSemana dia;
	
	public Musculo() {
		
	}


	public Musculo(Long id, String name, String observacao, DiaSemana dia) {
		super();
		this.id = id;
		this.name = name;
		this.observacao = observacao;
		this.dia = dia;
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

	public List<Exercicio> getExercicio() {
		return exercicio;
	}
	
	public DiaSemana getDia() {
		return dia;
	}


	public void setDia(DiaSemana dia) {
		this.dia = dia;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musculo other = (Musculo) obj;
		return Objects.equals(id, other.id);
	}
	
}
