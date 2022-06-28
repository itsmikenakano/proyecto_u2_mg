package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Estudiante;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private IEstudianteJdbcService iEstudianteJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante estudiante = new Estudiante();
		estudiante.setId(5);
		estudiante.setNombre("Orlando");
		estudiante.setApellido("Rodriguez");
		estudiante.setGenero("Masculino");
		estudiante.setEdad("25");
		
		//insertar
		this.iEstudianteJdbcService.guardar(estudiante);
		
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setId(5);
		estudiante1.setNombre("Cecilia");
		estudiante1.setApellido("Morales");
		estudiante1.setGenero("Femenino");
		estudiante1.setEdad("23");
		
		//actualizar
		this.iEstudianteJdbcService.actualizar(estudiante1);
		
		//eliminar
		this.iEstudianteJdbcService.eliminar(5);
		
		LOG.info("Se consulto la persona: " + this.iEstudianteJdbcService.buscarPorId(3));
		
	}

}
