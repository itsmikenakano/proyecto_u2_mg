package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;

public interface IPropietarioJpaService {
	
	public Propietario consultarPorCedula(String cedula);

	public void insertar(Propietario p);

	public int eliminarPorCedula(String cedula);

}
