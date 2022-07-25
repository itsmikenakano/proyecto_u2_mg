package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IAlbumRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Album;

@Service
public class AlbumServiceImpl implements IAlbumService{
	
	@Autowired
	private IAlbumRepository iAlbumRepository;

	@Override
	public void insertar(Album album) {
		this.iAlbumRepository.insertar(album);
		
	}

	@Override
	public Album consultar(Integer id) {
		return this.iAlbumRepository.consultar(id);
	}

	@Override
	public void actualizar(Album album) {
		this.iAlbumRepository.actualizar(album);
	}

	@Override
	public void eliminar(Integer id) {
		this.iAlbumRepository.eliminar(id);
	}

}
