package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		// ACTUALIZAR CON JQPL
		int resultado = this.iPersonaJpaService.actualizarPorApellido("FE", "Ruiz");
		LOG.info("Cantidad de registros actualizados: " + resultado);

		int resultado2 = this.iPersonaJpaService.eliminarPorGenero("M");
		LOG.info("Cantidad de registros eliminados: " + resultado2);

	}

}
