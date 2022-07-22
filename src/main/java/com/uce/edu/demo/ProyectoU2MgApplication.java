package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.CiudadanoP;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanopJpaService;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private ICiudadanopJpaService iCiudadanopJpaService;
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CiudadanoP c = new CiudadanoP();
		c.setNombre("Lorena");
		c.setApellido("Moreno");
		c.setFechaNacimiento(LocalDateTime.now());
		c.setCedula("12312");
		
		Pasaporte p = new Pasaporte();
		p.setNumero("12312");
		p.setFechaCaducidad(LocalDateTime.now());
		p.setFechaEmision(LocalDateTime.now());
		p.setCiudadanop(c);
		
		c.setPasaporte(p);
		
		this.iCiudadanopJpaService.insertar(c);
		
		LOG.info("Se ha buscado: " + this.iCiudadanopJpaService.buscarPorId(3));
		
		c.setApellido("Jimenez");
		c.setCedula("172832");
		
		this.iCiudadanopJpaService.actualizar(c);
		
		this.iCiudadanopJpaService.eliminar(2);
		
		
		
		
		

	}

}
