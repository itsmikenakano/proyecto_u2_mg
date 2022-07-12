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

		Persona per1 = new Persona();
		per1.setApellido("Rodriguez");
		per1.setNombre("Karla");
		per1.setCedula("12345");
		per1.setGenero("F");

		//this.iPersonaJpaService.guardar(per1);

		// 1. TypedQuery
		Persona perTyped = this.iPersonaJpaService.buscarPorCedulaTyped("123123123");
		LOG.info("Persona Typed: " + perTyped);

		// 2. TypedQuery
		Persona perNamed = this.iPersonaJpaService.buscarPorCedulaNamed("123123123");
		LOG.info("Persona Named: " + perNamed);

		// 3. TypedQuery
		Persona perTypedNamed = this.iPersonaJpaService.buscarPorCedulaTypedNamed("123123123");
		LOG.info("Persona TypedNamed: " + perTypedNamed);

		// 4. Varios NamedQuery
		List<Persona> listaPersona = this.iPersonaJpaService.buscarPorNombreApellido("Karla", "Rodriguez");
		for (Persona item : listaPersona) {
			LOG.info("Persona: " + item);
		}

	}

}
