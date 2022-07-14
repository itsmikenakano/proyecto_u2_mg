package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante e1 = new Estudiante();
		e1.setNombre("Michael");
		e1.setApellido("Garcia");
		e1.setCedula("2300290992");
		e1.setEdad("21");
		e1.setGenero("M");
		e1.setSemestre("6");
		
		//this.iEstudianteJpaService.insertar(e1);

		// 1. NativeQuery
		List<Estudiante> lista = this.iEstudianteJpaService.buscarPorNombreEdad("Melissa", "24");

		for (Estudiante e : lista) {
			LOG.info("Estudiane: " + e);
		}

		lista = this.iEstudianteJpaService.buscarPorApellidoCedula("Garcia","23");

		for (Estudiante e : lista) {
			LOG.info("Estudiane: " + e);
		}

		// 1. NamedNativeQuery
		lista = this.iEstudianteJpaService.buscarPorSemestreCedulaAsc("6");

		for (Estudiante e : lista) {
			LOG.info("Estudiane: " + e);
		}
		
		lista = this.iEstudianteJpaService.buscarPorGeneroNombreAsc("F");
		
		for (Estudiante e : lista) {
			LOG.info("Estudiane: " + e);
		}
		
		

	}

}
