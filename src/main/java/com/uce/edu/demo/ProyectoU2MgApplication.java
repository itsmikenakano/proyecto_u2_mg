package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.to.EstudianteTo;
import com.uce.edu.demo.to.PersonaTo;

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
		
		LOG.info("Dato con JPA: " + this.iEstudianteJpaService.buscarPorId(1));
		
		Estudiante e = new Estudiante();
		e.setId(4);
		e.setNombre("Luna");
		e.setApellido("Zambrano");
		e.setEdad("25");
		e.setGenero("Femenino");
		
		//GUARDAR
		this.iEstudianteJpaService.insertar(e);
		
		Estudiante e1 = new Estudiante();
		e1.setId(4);
		e1.setNombre("Emma");
		e1.setApellido("Ruiz");
		e1.setEdad("21");
		e1.setGenero("Femenino");
		
		//ACTUALIZACION
		this.iEstudianteJpaService.actualizar(e1);
		
		//ELIMINAR
		this.iEstudianteJpaService.eliminar(2);
		
		
	}

}
