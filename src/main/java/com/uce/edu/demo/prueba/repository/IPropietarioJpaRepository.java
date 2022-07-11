package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;

public interface IPropietarioJpaRepository {
	
	public Propietario consultarPorCedula(String cedula);

	public void insertar(Propietario p);

	public int eliminarPorCedula(String cedula);
}
