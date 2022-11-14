package com.gym.projetogym.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany
	@JoinTable(name = "tb_musculo_dia", joinColumns = @JoinColumn(name = "musculo_id"), inverseJoinColumns = @JoinColumn(name = "dia_id"))
	private Set<Dia> dias = new HashSet<>();
	
	public Musculo() {
		
	}


	public Musculo(Long id, String name, String observacao) {
		super();
		this.id = id;
		this.name = name;
		this.observacao = observacao;
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
	
	public Set<Dia> getDia() {
		return dias;
	}


	public void setDia(Set<Dia> dia) {
		this.dias = dia;
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


	@Override
	public String toString() {
		return name;
	}
	
	
}
