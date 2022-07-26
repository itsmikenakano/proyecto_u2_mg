package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro;

public interface ILibroRepository {

	public void insertar(Libro libro);

	public Libro buscar(Integer id);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);

}
