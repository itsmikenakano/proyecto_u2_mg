package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanopJpaRepository;
import com.uce.edu.demo.repository.modelo.CiudadanoP;

@Service
public class CiudadanopJpaServiceImpl implements ICiudadanopJpaService {

	@Autowired
	private ICiudadanopJpaRepository iCiudadanopJpaRepository;

	@Override
	public void insertar(CiudadanoP ciudadanoP) {
		this.iCiudadanopJpaRepository.insertar(ciudadanoP);
	}

	@Override
	public void actualizar(CiudadanoP ciudadanoP) {
		this.iCiudadanopJpaRepository.actualizar(ciudadanoP);
	}

	@Override
	public void eliminar(Integer id) {
		this.iCiudadanopJpaRepository.eliminar(id);

	}

	@Override
	public CiudadanoP buscarPorId(Integer id) {
		return this.iCiudadanopJpaRepository.buscarPorId(id);
	}
}
