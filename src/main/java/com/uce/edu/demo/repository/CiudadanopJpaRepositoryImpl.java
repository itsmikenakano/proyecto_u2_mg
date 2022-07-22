package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CiudadanoP;

@Repository
@Transactional
public class CiudadanopJpaRepositoryImpl implements ICiudadanopJpaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CiudadanoP ciudadanoP) {
		 this.entityManager.persist(ciudadanoP);
	}
	
	@Override
	public CiudadanoP buscarPorId(Integer id) {
		return this.entityManager.find(CiudadanoP.class, id);
	}

	@Override
	public void actualizar(CiudadanoP ciudadanoP) {
		this.entityManager.merge(ciudadanoP);
	}

	@Override
	public void eliminar(Integer id) {
		CiudadanoP ciudadanoP = this.buscarPorId(id);
		this.entityManager.remove(ciudadanoP);
	}

	


}
