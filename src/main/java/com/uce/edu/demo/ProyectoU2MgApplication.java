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

		Estudiante e = new Estudiante();
		e.setNombre("Melissa");
		e.setApellido("Jimenez");
		e.setEdad("24");
		e.setGenero("F");
		e.setSemestre("3");

		this.iEstudianteJpaService.insertar(e);

		// 1. TypedQuery
		List<Estudiante> listaEstudiante = this.iEstudianteJpaService.buscarPorNombreGenero("Melissa", "F");
		LOG.info("Estudiante Typed: ");
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante: " + item);
		}

		// 2. TypedQuery
		listaEstudiante = this.iEstudianteJpaService.buscarPorEdadGenero("22", "F");
		LOG.info("Estudiante Typed: ");
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante: " + item);
		}
		
		// 3. NamedQuery
		listaEstudiante = this.iEstudianteJpaService.buscarPorEdadFemenino("21");
		LOG.info("Persona Named: " );
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante: " + item);
		}
		
		// 4. NamedQuery
		listaEstudiante = this.iEstudianteJpaService.buscarPorEdadMasculino("22");
		LOG.info("Persona Named: " );
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante: " + item);
		}

		// 5. TypedNamedQuery
		listaEstudiante = this.iEstudianteJpaService.buscarPorApellidoSemestreAsc("Jimenez");
		LOG.info("Persona Named: " );
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante: " + item);
		}

		// 6. TypedNamedQuery
		listaEstudiante = this.iEstudianteJpaService.buscarPorSemestreApellidoAsc("6");
		LOG.info("Persona Named: " );
		for (Estudiante item : listaEstudiante) {
			LOG.info("Estudiante: " + item);
		}

	}

}
