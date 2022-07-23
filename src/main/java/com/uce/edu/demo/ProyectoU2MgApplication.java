package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private IHabitacionService iHabitacionService;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Hotel hotel1 = new Hotel();
		hotel1.setNombre("Hilton Colon GUY");
		hotel1.setDireccion("Malecon");
		
		this.iHotelService.insertar(hotel1);
		*/
		
		//Buscar numero
		Hotel hote= new Hotel();
		hote.setId(1);
		
		Habitacion habi1 = new Habitacion();
		habi1.setNumero("A2334");
		habi1.setPiso("10");
		habi1.setTipo("Familiar");
		habi1.setHotel(hote);
		
		Habitacion habi2 = new Habitacion();
		habi2.setNumero("1231223");
		habi2.setPiso("1");
		habi2.setTipo("Matrimonial");
		habi2.setHotel(hote);
		
		this.iHabitacionService.insertar(habi1);
		this.iHabitacionService.insertar(habi2);
	}

}
