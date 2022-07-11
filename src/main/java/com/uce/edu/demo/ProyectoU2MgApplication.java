package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IPropietarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private IPropietarioJpaService iPropietarioJpaService;

	@Autowired
	private IVehiculoJpaService iVehiculoJpaService;
	
	@Autowired
	private IMatriculaGestorService iMatriculaGestorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Propietario p = new Propietario();
		p.setNombre("Michael");
		p.setApellido("Garcia");
		p.setCedula("12345");
		p.setFechaNacimiento(LocalDateTime.now());

		//this.iPropietarioJpaService.insertar(p);

//		LOG.info("Propietario Consultado: " +
//		this.iPropietarioJpaService.consultarPorCedula("2300290992"));

		//this.iPropietarioJpaService.eliminarPorCedula("2300290992");

		Vehiculo v = new Vehiculo();
		v.setMarca("Toyota");
		v.setPlaca("PYJ2022");
		v.setPrecio(new BigDecimal(25000));
		v.setTipo("Pesado");
		
		//this.iVehiculoJpaService.insertar(v);
		
		//LOG.info("Vehiculo Consultado: " + this.iVehiculoJpaService.buscarPorPlaca("PYC2022"));
		
		//this.iVehiculoJpaService.eliminarPorPlaca("PYJ2022");
		
		this.iMatriculaGestorService.generar(p.getCedula(), v.getPlaca());

	}

}
