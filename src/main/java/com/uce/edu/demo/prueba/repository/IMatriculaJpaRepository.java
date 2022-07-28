package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.repository.modelo.Matricula;

public interface IMatriculaJpaRepository {
	public void insertar(Matricula m);

	public Matricula buscarPorFecha(String fechaMatricula);

	public void actualizar(Matricula m);

	public int eliminarPorFecha(String fechaMatricula);
}
