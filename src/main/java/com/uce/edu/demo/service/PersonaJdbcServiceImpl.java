package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.Persona;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService {

	@Autowired
	private IPersonaJdbcRepository iPersonaJdbcRepository;

	@Override
	public void guardar(Persona persona) {
		this.iPersonaJdbcRepository.insertar(persona);

	}

	@Override
	public void actualizar(Persona persona) {
		this.iPersonaJdbcRepository.actualizar(persona);
	}

	@Override
	public void eliminar(int id) {
		this.iPersonaJdbcRepository.eliminar(id);
		
	}

	@Override
	public Persona consultarPorId(int id) {
		return this.iPersonaJdbcRepository.buscarPorId(id);
	}

}
