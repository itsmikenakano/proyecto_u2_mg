package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	public void insertar(Estudiante e);

	public Estudiante buscarPorId(Integer id);

	public void actualizar(Estudiante e);

	public void eliminar(Integer id);
}
