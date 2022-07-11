package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.prueba.repository.modelo.Propietario;

@Service
public class PropietarioJpaServiceImpl implements IPropietarioJpaService {
	@Autowired
	private IPropietarioJpaRepository iPropietarioJpaRepository;

	@Override
	public Propietario consultarPorCedula(String cedula) {
		return this.iPropietarioJpaRepository.consultarPorCedula(cedula);
	}

	@Override
	public void insertar(Propietario p) {
		this.iPropietarioJpaRepository.insertar(p);
	}

	@Override
	public int eliminarPorCedula(String cedula) {
		return this.iPropietarioJpaRepository.eliminarPorCedula(cedula);
	}

}
