package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.PersonaTo;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService {

	@Autowired
	private IPersonaJdbcRepository iPersonaJdbcRepository;

	@Override
	public void guardar(PersonaTo persona) {
		this.iPersonaJdbcRepository.insertar(persona);

	}

	@Override
	public void actualizar(PersonaTo persona) {
		this.iPersonaJdbcRepository.actualizar(persona);
	}

	@Override
	public void eliminar(int id) {
		this.iPersonaJdbcRepository.eliminar(id);
		
	}

	@Override
	public PersonaTo consultarPorId(int id) {
		return this.iPersonaJdbcRepository.buscarPorId(id);
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iPersonaJdbcRepository.buscarTodos();
	}

}
