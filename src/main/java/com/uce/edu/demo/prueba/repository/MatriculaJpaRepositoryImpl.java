package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Matricula;

@Repository
@Transactional
public class MatriculaJpaRepositoryImpl implements IMatriculaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Matricula m) {
		this.entityManager.persist(m);
	}

	@Override
	public Matricula buscarPorFecha(String fechaMatricula) {
		Query myQuery = this.entityManager.createQuery("SELECT m FROM Matricula m WHERE m.fechaMatricula= :fecha");
		myQuery.setParameter("fecha", fechaMatricula);
		return (Matricula) myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Matricula m) {
		this.entityManager.merge(m);
	}

	@Override
	public int eliminarPorFecha(String fechaMatricula) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Matricula m WHERE m.fechaMatricula= :fecha");
		myQuery.setParameter("fecha", fechaMatricula);
		return myQuery.executeUpdate();
	}

}
