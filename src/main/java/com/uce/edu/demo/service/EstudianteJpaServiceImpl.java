package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;

	@Override
	public void insertar(Estudiante e) {
		this.iEstudianteJpaRepository.insertar(e);

	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.iEstudianteJpaRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.iEstudianteJpaRepository.actualizar(e);

	}

	@Override
	public void eliminar(Integer id) {
		this.iEstudianteJpaRepository.eliminar(id);

	}

	@Override
	public List<Estudiante> buscarPorNombreGenero(String nombre, String genero) {
		return this.iEstudianteJpaRepository.buscarPorNombreGenero(nombre, genero);
	}

	@Override
	public List<Estudiante> buscarPorEdadGenero(String edad, String genero) {
		return this.iEstudianteJpaRepository.buscarPorEdadGenero(edad, genero);
	}

	@Override
	public List<Estudiante> buscarPorEdadMasculino(String edad) {
		return this.iEstudianteJpaRepository.buscarPorEdadMasculino(edad);
	}

	@Override
	public List<Estudiante> buscarPorEdadFemenino(String edad) {
		return this.iEstudianteJpaRepository.buscarPorEdadFemenino(edad);
	}

	@Override
	public List<Estudiante> buscarPorSemestreApellidoAsc(String semestre) {

		return this.iEstudianteJpaRepository.buscarPorSemestreApellidoAsc(semestre);
	}

	@Override
	public List<Estudiante> buscarPorApellidoSemestreAsc(String apellido) {
		return this.iEstudianteJpaRepository.buscarPorApellidoSemestreAsc(apellido);
	}

	@Override
	public List<Estudiante> buscarPorNombreEdad(String nombre, String edad) {
		return this.iEstudianteJpaRepository.buscarPorNombreEdad(nombre, edad);
	}

	@Override
	public List<Estudiante> buscarPorApellidoCedula(String apellido, String cedula) {
		return this.iEstudianteJpaRepository.buscarPorApellidoCedula(apellido, cedula);
	}

	@Override
	public List<Estudiante> buscarPorSemestreCedulaAsc(String semestre) {
		return this.iEstudianteJpaRepository.buscarPorSemestreCedulaAsc(semestre);
	}

	@Override
	public List<Estudiante> buscarPorGeneroNombreAsc(String genero) {
		return this.iEstudianteJpaRepository.buscarPorGeneroNombreAsc(genero);
	}

}
