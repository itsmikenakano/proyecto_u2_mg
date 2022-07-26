package com.uce.edu.demo.repository.modelo.manytomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro_autor_2")
public class LibroAutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liau2_id_seq")
	@SequenceGenerator(name = "liau2_id_seq", sequenceName = "liau2_id_seq", allocationSize = 1)
	@Column(name = "liau2_id")
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "liau2_id_libro")
	private Libro2 libro;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "liau2_id_autor")
	private Autor2 autor;

	@Override
	public String toString() {
		return "LibroAutor [libro=" + libro + ", autor=" + autor + "]";
	}

	// SET Y GET
	public Libro2 getLibro() {
		return libro;
	}

	public void setLibro(Libro2 libro) {
		this.libro = libro;
	}

	public Autor2 getAutor() {
		return autor;
	}

	public void setAutor(Autor2 autor) {
		this.autor = autor;
	}

}
