package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.IArtistaService;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private ILibroService iLibroService;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Libro libro = new Libro();
		libro.setTitulo("JPA5");
		libro.setCantidadPaginas(40);
		
		Autor autor1 = new Autor();
		autor1.setNombre("Adam Blen2");
		
		Autor autor2 = new Autor();
		autor2.setNombre("Adam Blen3");
		
		Set<Autor> autores = new HashSet<>();
		autores.add(autor1);
		autores.add(autor2);
		
		libro.setAutores(autores);
		
		this.iLibroService.insertar(libro);
		
		
	}

}
