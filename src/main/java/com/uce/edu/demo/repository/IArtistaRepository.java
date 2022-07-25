package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Artista;

public interface IArtistaRepository {
	
	public void insertar(Artista artista);
	
	public Artista consultar(Integer id);
	
	public void actualizar(Artista artista);
	
	public void eliminar(Integer id);
	

}
