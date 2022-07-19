package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.service.IEstudianteJpaService;

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

		List<EstudianteContadorSemestre> listaEstudiante = this.iEstudianteJpaService.buscarContadorPorSemestre();

		for (EstudianteContadorSemestre e : listaEstudiante) {
			LOG.info("EstudianteContadorGenero: " + e);
		}

		List<EstudianteSencillo> miListaEstudiante = this.iEstudianteJpaService.buscarEstudianteSencillo("g");

		for (EstudianteSencillo item : miListaEstudiante) {
			LOG.info("EstudianteSencillo: " + item);
		}

	}

}
