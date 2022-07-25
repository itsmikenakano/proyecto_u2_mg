package com.uce.edu.demo.repository.modelo.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arti_id_seq")
	@SequenceGenerator(name = "arti_id_seq", sequenceName = "arti_id_seq", allocationSize = 1)
	@Column(name = "arti_id")
	private Integer id;

	@Column(name = "arti_nombre")
	private String nombre;

	@Column(name = "arti_edad")
	private String edad;

	@OneToMany(mappedBy = "artista")
	private List<Album> album;

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}

}
