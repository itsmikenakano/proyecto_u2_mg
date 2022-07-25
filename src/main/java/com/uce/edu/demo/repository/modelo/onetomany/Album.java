package com.uce.edu.demo.repository.modelo.onetomany;

import java.time.LocalDateTime;

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
@Table(name = "album")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "albu_id_seq")
	@SequenceGenerator(name = "albu_id_seq", sequenceName = "albu_id_seq", allocationSize = 1)
	@Column(name = "albu_id")
	private Integer id;

	@Column(name = "albu_nombre")
	private String nombre;

	@Column(name = "albu_genero")
	private String genero;

	@Column(name = "albu_fecha_lanzamiento")
	private LocalDateTime fechaLanzamiento;

	@ManyToOne
	@JoinColumn(name = "albu_id_artista")
	private Artista artista;

	@Override
	public String toString() {
		return "Album [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", fechaLanzamiento="
				+ fechaLanzamiento + ", artista=" + artista + "]";
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDateTime getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(LocalDateTime fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

}
