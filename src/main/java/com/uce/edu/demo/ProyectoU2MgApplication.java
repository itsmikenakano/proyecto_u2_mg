package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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

		List<PersonaSencilla> listaPersona = this.iPersonaJpaService.buscarPorApellidoSencillo("Rodriguez");

		for (PersonaSencilla p : listaPersona) {
			LOG.info("Persona Sencilla: " + p);
		}

		List<PersonaContadorGenero> miListaPersonaGenero = this.iPersonaJpaService.consultarCantidadPorGenero();

		for (PersonaContadorGenero item : miListaPersonaGenero) {
			LOG.info("Genero: " + item);
		}

	}

}
