package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository iLibroRepository;

	@Override
	public void insertar(Libro libro) {
		this.iLibroRepository.insertar(libro);

	}

	@Override
	public Libro buscar(Integer id) {
		return this.iLibroRepository.buscar(id);

	}

	@Override
	public void actualizar(Libro libro) {
		this.iLibroRepository.actualizar(libro);

	}

	@Override
	public void eliminar(Integer id) {
		this.iLibroRepository.eliminar(id);

	}

}
