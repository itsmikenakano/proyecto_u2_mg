package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Artista;

@Repository
@Transactional
public class ArtistaRepositoryImpl implements IArtistaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Artista artista) {
		this.entityManager.persist(artista);
		
	}

	@Override
	public Artista consultar(Integer id) {
		return this.entityManager.find(Artista.class, id);
	}

	@Override
	public void actualizar(Artista artista) {
		this.entityManager.merge(artista);
		
	}

	@Override
	public void eliminar(Integer id) {
		Artista a = this.consultar(id);
		this.entityManager.remove(a);
	}

}
