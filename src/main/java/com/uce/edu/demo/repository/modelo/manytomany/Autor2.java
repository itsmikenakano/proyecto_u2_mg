package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor2")
public class Autor2 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto2_id_seq")
	@SequenceGenerator(name = "auto2_id_seq", sequenceName = "auto2_id_seq", allocationSize = 1)
	@Column(name = "auto2_id")
	private Integer id;

	@Column(name = "auto2_nombre")
	private String nombre;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<LibroAutor> autoresLibros;

	@Override
	public String toString() {
		return "Autor2 [id=" + id + ", nombre=" + nombre + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LibroAutor> getAutoresLibros() {
		return autoresLibros;
	}

	public void setAutoresLibros(List<LibroAutor> autoresLibros) {
		this.autoresLibros = autoresLibros;
	}

}
