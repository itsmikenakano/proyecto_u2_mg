package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Estudiante.buscarPorEdadAscM", query = "SELECT e FROM Estudiante e WHERE e.edad = :datoEdad AND e.genero= 'M' ORDER BY e.edad ASC")
@NamedQuery(name = "Estudiante.buscarPorEdadAscF", query = "SELECT e FROM Estudiante e WHERE e.edad = :datoEdad AND e.genero= 'F' ORDER BY e.edad ASC")
@NamedQuery(name = "Estudiante.buscarPorSemestreApellidoAsc", query = "SELECT e FROM Estudiante e WHERE e.semestre= :datoSemestre ORDER BY e.apellido ASC")
@NamedQuery(name = "Estudiante.buscarPorApellidoSemestreAsc", query = "SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido ORDER BY e.semestre ASC")

@NamedNativeQuery(name = "Estudiante.buscarPorSemestreCedulaAsc", query = "SELECT * FROM estudiante WHERE estu_semestre = :datoSemestre ORDER BY estu_cedula ASC", resultClass = Estudiante.class)
@NamedNativeQuery(name = "Estudiante.buscarPorGeneroNombreAsc", query = "SELECT * FROM estudiante WHERE estu_genero = :datoGenero ORDER BY estu_nombre ASC", resultClass = Estudiante.class)
public class Estudiante {

	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_id_seq")
	@SequenceGenerator(name = "estu_id_seq", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_genero")
	private String genero;

	@Column(name = "estu_edad")
	private String edad;

	@Column(name = "estu_semestre")
	private String semestre;

	@Column(name = "estu_cedula")
	private String cedula;

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", edad=" + edad + ", semestre=" + semestre + ", cedula=" + cedula + "]";
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
