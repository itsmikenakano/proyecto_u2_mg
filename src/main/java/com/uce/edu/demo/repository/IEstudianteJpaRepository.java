package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	public void insertar(Estudiante e);

	public Estudiante buscarPorId(Integer id);

	public void actualizar(Estudiante e);

	public void eliminar(Integer id);

	public List<Estudiante> buscarPorNombreGenero(String nombre, String genero);
	
	public List<Estudiante> buscarPorEdadGenero(String edad, String genero);
	
	public List<Estudiante> buscarPorEdadMasculino(String edad);
	
	public List<Estudiante> buscarPorEdadFemenino(String edad);
	
	public List<Estudiante> buscarPorSemestreApellidoAsc(String semestre);
	
	public List<Estudiante> buscarPorApellidoSemestreAsc(String apellido);
	
	public List<Estudiante> buscarPorNombreEdad(String nombre, String edad);
	
	public List<Estudiante> buscarPorApellidoCedula(String apellido, String cedula);
	
	public List<Estudiante> buscarPorSemestreCedulaAsc(String semestre);
	
	public List<Estudiante> buscarPorGeneroNombreAsc(String genero);
	
	public List<Estudiante> buscarPorSemestreDinamico(String semestre, String apellido, String genero);
	
	public List<Estudiante> buscarPorNombreDinamico(String nombre, String letra, String edad);
	
	
	
	
	
	
	


}
