package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.service.ICiudadanoJpaService;
import com.uce.edu.demo.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;
	
	@Autowired
	private ICiudadanoJpaService iCiudadanoJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<EstudianteContadorSemestre> listaEstudiante = this.iEstudianteJpaService.buscarContadorPorSemestre();

		for (EstudianteContadorSemestre e : listaEstudiante) {
			LOG.info("EstudianteContadorSemestre: " + e);
		}

		List<EstudianteSencillo> miListaEstudiante = this.iEstudianteJpaService.buscarEstudianteSencillo("g");

		for (EstudianteSencillo item : miListaEstudiante) {
			LOG.info("EstudianteSencillo: " + item);
		}
		
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Joss");
		ciu1.setApellido("Riera");
		
		Empleado empl1 = new Empleado();
		empl1.setCodigoIess("123");
		empl1.setSalario(new BigDecimal(200));
		empl1.setCiudadano(ciu1);
		
		ciu1.setEmpleado(empl1);
		this.iCiudadanoJpaService.insertar(ciu1);
		
		Ciudadano ciu2= new Ciudadano();
		ciu2.setNombre("Joss");
		ciu2.setApellido("Riera");
		
		Empleado empl2 = new Empleado();
		empl2.setCodigoIess("123");
		empl2.setSalario(new BigDecimal(200));
		empl2.setCiudadano(ciu1);
		
		ciu2.setEmpleado(empl2);
		//this.empleadoService.insertar(empl2)

	}

}
