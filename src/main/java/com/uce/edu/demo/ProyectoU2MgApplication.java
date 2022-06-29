package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.to.Estudiante;
import com.uce.edu.demo.to.PersonaTo;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		LOG.info("Dato con JPA: " + this.iPersonaJpaService.buscarPorId(3));
		
		Persona per = new Persona();
		per.setId(7);
		per.setNombre("Victor");
		per.setApellido("Alvear");
		
		//GUARDAR
		//this.iPersonaJpaService.guardar(per);
		
		Persona per1 = new Persona();
		per1.setId(1);
		per1.setNombre("Sofia");
		per1.setApellido("Alvarez");
		
		//ACTUALIZACION
		//this.iPersonaJpaService.actualizar(per1);
		
		this.iPersonaJpaService.eliminar(2);
		
		
	}

}
