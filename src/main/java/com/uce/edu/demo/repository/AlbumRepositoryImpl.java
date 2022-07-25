package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Album;

@Repository
@Transactional
public class AlbumRepositoryImpl implements IAlbumRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Album album) {
		this.entityManager.persist(album);
	}

	@Override
	public Album consultar(Integer id) {
		return this.entityManager.find(Album.class, id);
	}

	@Override
	public void actualizar(Album album) {
		this.entityManager.merge(album);
		
	}

	@Override
	public void eliminar(Integer id) {
		Album a = this.consultar(id);
		this.entityManager.remove(a);
	}

}
