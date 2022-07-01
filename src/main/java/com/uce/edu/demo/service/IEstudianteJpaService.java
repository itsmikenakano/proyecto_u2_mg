package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	
	public void insertar(Estudiante e);

	public Estudiante buscarPorId(Integer id);

	public void actualizar(Estudiante e);

	public void eliminar(Integer id);

}
