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
		p.setNombre("Chloe");
		p.setApellido("Jimenez");
		p.setFechaNacimiento(LocalDateTime.now());
		p.setCedula("07654");
		this.iPropietarioJpaService.insertar(p);
		
		Vehiculo v = new Vehiculo();
		v.setMarca("Chevrolet");
		v.setPlaca("PTE230");
		v.setPrecio(new BigDecimal(10000));
		v.setTipo("Liviano");
		this.iVehiculoJpaService.insertar(v);
		
		this.iMatriculaGestorService.generar(p.getCedula(),v.getPlaca());
		
	}

}
