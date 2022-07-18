package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

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
		// Criteria API Query
		List<Estudiante> listaEstudiante = this.iEstudianteJpaService.buscarPorNombreDinamico("Melissa", "L", "21");
		
		for(Estudiante e: listaEstudiante) {
			LOG.info("Estudiante Criteria API: " + e);
		}
		
		listaEstudiante = this.iEstudianteJpaService.buscarPorNombreDinamico("Luisa", "J", "20");
		
		for(Estudiante e: listaEstudiante) {
			LOG.info("Estudiante Criteria API: " + e);
		}
		
		listaEstudiante = this.iEstudianteJpaService.buscarPorSemestreDinamico("6", "Rodriguez", "F");
		
		for(Estudiante e: listaEstudiante) {
			LOG.info("Estudiante Criteria API: " + e);
		}
		
		listaEstudiante = this.iEstudianteJpaService.buscarPorSemestreDinamico("3", "Jimenez", "F");
		
		for(Estudiante e: listaEstudiante) {
			LOG.info("Estudiante Criteria API: " + e);
		}
		
	}

}
