package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Album;

public interface IAlbumRepository {

	public void insertar(Album album);

	public Album consultar(Integer id);

	public void actualizar(Album album);

	public void eliminar(Integer id);
}
