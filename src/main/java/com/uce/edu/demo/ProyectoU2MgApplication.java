package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// BUSCAR
		// LOG.info("Dato con JPA: " + this.iPersonaJpaService.buscarPorId(3));

		Persona per = new Persona();
//		per.setId(8);
		per.setNombre("Lucia");
		per.setApellido("Saldarriaga");
		per.setGenero("F");
		per.setCedula("2389311392");

		// GUARDAR
		// this.iPersonaJpaService.guardar(per);

		Persona per1 = new Persona();
		per1.setId(3);
		per1.setNombre("Jorge");
		per1.setApellido("Ochoa");

		// ACTUALIZACION
		// this.iPersonaJpaService.actualizar(per1);

		// ELIMINAR
		// this.iPersonaJpaService.eliminar(2);

		// Persona p = this.iPersonaJpaService.buscarPorCedula("2376582392");
		// LOG.info("Consulta con JPQL-> Persona Encontrada: " + p);

		/*
		 * List<Persona> listaPersona =
		 * this.iPersonaJpaService.buscarPorApellido("Ruiz");
		 * 
		 * for (Persona item : listaPersona) { LOG.info("Persona: " + item); }
		 */

		// BuscarPorNombre
		List<Persona> listaPersona1 = this.iPersonaJpaService.buscarPorNombre("Madelyn");

		for (Persona item : listaPersona1) {
			LOG.info("Persona: " + item);
		}

		// BuscarPorNombre
		List<Persona> listaPersona2 = this.iPersonaJpaService.buscarPorGenero("F");

		for (Persona item : listaPersona2) {
			LOG.info("Persona: " + item);
		}

	}

}
