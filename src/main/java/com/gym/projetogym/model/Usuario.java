package com.gym.projetogym.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date date;
	private String sexo;
	private Double peso;
	private Double altura;
	private Double objetivoPeso;
	
	public Usuario(Long id, String name, Date date, String sexo, Double peso, Double altura, Double objetivoPeso) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.objetivoPeso = objetivoPeso;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getObjetivoPeso() {
		return objetivoPeso;
	}

	public void setObjetivoPeso(Double objetivoPeso) {
		this.objetivoPeso = objetivoPeso;
	}
	
	
	
	
}
