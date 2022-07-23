package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetoone.CiudadanoP;

public interface ICiudadanopJpaService {

	public void insertar(CiudadanoP ciudadanoP);

	public void actualizar(CiudadanoP ciudadanoP);

	public void eliminar(Integer id);

	public CiudadanoP buscarPorId(Integer id);
}
