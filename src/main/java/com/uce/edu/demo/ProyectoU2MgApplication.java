package com.uce.edu.demo;

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
		// Criteria API Query
		Persona perTyped = this.iPersonaJpaService.buscarPorCedulaCriteriaApi("12345");
		LOG.info("Persona Criteria API: " + perTyped);
		
		Persona perDinamica = this.iPersonaJpaService.buscarDinamicamente("Karla", "Roldos", "F");
		LOG.info("Persona Dinamica: " + perDinamica);

	}

}
