package com.uce.edu.demo.service;

import com.uce.edu.demo.to.Estudiante;

public interface IEstudianteJdbcService {
	public void guardar(Estudiante e);
	
	public Estudiante buscarPorId(int id);
	
	public void actualizar(Estudiante e);
	
	public void eliminar(int id);
}
