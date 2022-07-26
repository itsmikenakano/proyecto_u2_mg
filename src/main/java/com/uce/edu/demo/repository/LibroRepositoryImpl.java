package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {
		this.entityManager.persist(libro);

	}

	@Override
	public Libro buscar(Integer id) {
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void actualizar(Libro libro) {
		this.entityManager.merge(libro);

	}

	@Override
	public void eliminar(Integer id) {
		Libro l = this.buscar(id);
		this.entityManager.remove(l);

	}

}
