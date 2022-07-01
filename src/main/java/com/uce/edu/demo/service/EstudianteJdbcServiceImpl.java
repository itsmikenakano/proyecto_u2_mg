package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.to.EstudianteTo;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService {

	@Autowired
	private IEstudianteJdbcRepository iEstudianteJdbcRepository;

	@Override
	public void guardar(EstudianteTo e) {
		this.iEstudianteJdbcRepository.insertar(e);

	}

	@Override
	public EstudianteTo buscarPorId(int id) {
		return this.iEstudianteJdbcRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(EstudianteTo e) {
		this.iEstudianteJdbcRepository.actualizar(e);

	}

	@Override
	public void eliminar(int id) {
		this.iEstudianteJdbcRepository.eliminar(id);

	}

}
