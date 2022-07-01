package com.uce.edu.demo.service;

import com.uce.edu.demo.to.EstudianteTo;

public interface IEstudianteJdbcService {
	public void guardar(EstudianteTo e);
	
	public EstudianteTo buscarPorId(int id);
	
	public void actualizar(EstudianteTo e);
	
	public void eliminar(int id);
}
