package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;
import com.uce.edu.demo.repository.modelo.manytomany.LibroAutor;
import com.uce.edu.demo.service.IAutor2Service;
import com.uce.edu.demo.service.ILibro2Service;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private ILibro2Service iLibro2Service;

	@Autowired
	private IAutor2Service iAutor2Service;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Insertar 1 libro que tiene dos autores
		Libro2 libro = new Libro2();
		libro.setTitulo("JPA1");
		libro.setCantidadPaginas(2000);

		Autor2 autor = new Autor2();
		autor.setNombre("Autor1");

		Autor2 autor2 = new Autor2();
		autor2.setNombre("Autor2");

		List<LibroAutor> listaLibroAutor = new ArrayList<>();

		LibroAutor libroAutor = new LibroAutor();
		libroAutor.setLibro(libro);
		libroAutor.setAutor(autor);

		listaLibroAutor.add(libroAutor);

		LibroAutor libroAutor2 = new LibroAutor();
		libroAutor2.setLibro(libro);
		libroAutor2.setAutor(autor2);

		listaLibroAutor.add(libroAutor2);

		libro.setLibrosAutores(listaLibroAutor);

		this.iLibro2Service.insertar(libro);

		// insertar 1 autor que escribió dos libros

		Autor2 autor3 = new Autor2();
		autor3.setNombre("Autor3");

		Libro2 libro2 = new Libro2();
		libro2.setTitulo("JPA2");
		libro2.setCantidadPaginas(150);

		Libro2 libro3 = new Libro2();
		libro3.setTitulo("JPA3");
		libro3.setCantidadPaginas(175);

		listaLibroAutor.clear();

		LibroAutor libroAutor3 = new LibroAutor();
		libroAutor3.setLibro(libro2);
		libroAutor3.setAutor(autor3);

		listaLibroAutor.add(libroAutor3);

		LibroAutor libroAutor4 = new LibroAutor();
		libroAutor4.setLibro(libro3);
		libroAutor4.setAutor(autor3);

		listaLibroAutor.add(libroAutor4);

		autor3.setAutoresLibros(listaLibroAutor);

		this.iAutor2Service.insertar(autor3);

	}

}
