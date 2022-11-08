package com.gym.projetogym.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class DiaSemana implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String diaSemana;
	
	@OneToMany(mappedBy = "diaSemana")
	private List<Musculo> musculo = new ArrayList<>();
	
	public DiaSemana() {
		
	}

	public DiaSemana(Long id, String diaSemana) {
		super();
		this.id = id;
		this.diaSemana = diaSemana;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public List<Musculo> getMusculo() {
		return musculo;
	}

	public void setMusculo(List<Musculo> musculo) {
		this.musculo = musculo;
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
		DiaSemana other = (DiaSemana) obj;
		return Objects.equals(id, other.id);
	}

}
