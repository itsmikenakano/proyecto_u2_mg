package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoJpaRepositoryImpl implements IVehiculoJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo v) {
		this.entityManager.persist(v);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		Query myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa= :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);
		return (Vehiculo)myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Vehiculo v) {
		this.entityManager.merge(v);
	}

	@Override
	public int eliminarPorPlaca(String placa) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Vehiculo v WHERE v.placa= :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);
		return myQuery.executeUpdate();
	}

}
