package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
				"SELECT e FROM Estudiante e WHERE e.edad = :datoEdad AND e.genero= : datoGenero ORDER BY e.edad ASC",
				Estudiante.class);
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
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestreApellidoAsc",
				Estudiante.class);
		myQuery.setParameter("datoSemestre", semestre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoSemestreAsc(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoSemestreAsc",
				Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}


	@Override
	public List<Estudiante> buscarPorNombreEdad(String nombre, String edad) {
		// NativeQuery
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE estu_nombre = :datoNombre AND estu_edad = :datoEdad", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoCedula(String apellido, String cedula) {
		// NativeQuery
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE estu_apellido = :datoApellido AND estu_cedula LIKE :datoCedula",
				Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoCedula", "%"+cedula+"%");
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorSemestreCedulaAsc(String semestre) {
		// NamedNativeQuery
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestreCedulaAsc",
				Estudiante.class);
		myQuery.setParameter("datoSemestre", semestre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorGeneroNombreAsc(String genero) {
		// NamedNativeQuery
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorGeneroNombreAsc",
				Estudiante.class);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorSemestreDinamico(String semestre, String apellido, String genero) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoSemestre = myCriteria.equal(myTabla.get("semestre"), semestre);
		Predicate predicadoApellido = myCriteria.like(myTabla.get("apellido"), apellido);
		Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);
		Predicate miPredicadoFinal = null;
		if (semestre.equals("6")) {
			miPredicadoFinal = myCriteria.or(predicadoGenero, predicadoApellido);
			miPredicadoFinal = myCriteria.and(miPredicadoFinal, predicadoSemestre);
		} else {
			miPredicadoFinal = myCriteria.and(predicadoGenero, predicadoApellido, predicadoSemestre);
		}
		myQuery.select(myTabla).where(miPredicadoFinal);
		
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombreDinamico(String nombre, String letra, String edad) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoLetra = myCriteria.notLike(myTabla.get("nombre"), letra);
		Predicate predicadoEdad = myCriteria.equal(myTabla.get("edad"), edad);
		Predicate predicateApellido = myCriteria.like(myTabla.get("apellido"), letra);
		Predicate miPredicadoFinal = null;
		if (edad.equals("21")) {
			miPredicadoFinal = myCriteria.and(predicadoLetra, predicadoEdad);

		} else {
			miPredicadoFinal = myCriteria.or(predicadoEdad, predicateApellido);
		}
		myQuery.select(myTabla).where(miPredicadoFinal);
		
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

}
