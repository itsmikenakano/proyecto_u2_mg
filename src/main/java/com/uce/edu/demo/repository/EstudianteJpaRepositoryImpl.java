package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante e) {
		this.entityManager.persist(e);

	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.entityManager.merge(e);
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante e = this.buscarPorId(id);
		this.entityManager.remove(e);

	}

	@Override
	public List<Estudiante> buscarPorNombreGenero(String nombre, String genero) {
		TypedQuery<Estudiante> miTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre AND e.genero= : datoGenero", Estudiante.class);
		miTypedQuery.setParameter("datoNombre", nombre);
		miTypedQuery.setParameter("datoGenero", genero);
		return miTypedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadGenero(String edad, String genero) {
		TypedQuery<Estudiante> miTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.edad = :datoEdad AND e.genero= : datoGenero ORDER BY e.edad ASC", Estudiante.class);
		miTypedQuery.setParameter("datoEdad", edad);
		miTypedQuery.setParameter("datoGenero", genero);
		return miTypedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadMasculino(String edad) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdadAscM");
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Estudiante> buscarPorEdadFemenino(String edad) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdadAscF");
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorSemestreApellidoAsc(String semestre) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestreApellidoAsc", Estudiante.class);
		myQuery.setParameter("datoSemestre", semestre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoSemestreAsc(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoSemestreAsc", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}
	
	

}
