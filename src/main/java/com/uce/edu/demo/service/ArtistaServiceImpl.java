package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IArtistaRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Artista;

@Service
public class ArtistaServiceImpl implements IArtistaService {

	@Autowired
	private IArtistaRepository iArtistaRepository;

	@Override
	public void insertar(Artista artista) {
		this.iArtistaRepository.insertar(artista);
	}

	@Override
	public Artista consultar(Integer id) {
		return this.iArtistaRepository.consultar(id);
	}

	@Override
	public void actualizar(Artista artista) {
		this.iArtistaRepository.actualizar(artista);

	}

	@Override
	public void eliminar(Integer id) {
		this.iArtistaRepository.eliminar(id);

	}

}
