package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class EstudianteContadorSemestre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String semestre;
	private Long numero;
	
	public EstudianteContadorSemestre() {
		
	}

	public EstudianteContadorSemestre(String semestre, Long numero) {
		super();
		this.semestre = semestre;
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "EstudianteContadorSemestre [semestre=" + semestre + ", numero=" + numero + "]";
	}

	//SET Y GET
	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
	
	
	

}
