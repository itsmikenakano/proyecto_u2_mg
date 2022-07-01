package com.uce.edu.demo.service;

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

}
