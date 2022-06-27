package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner{
	
	private static Logger logJava = Logger.getLogger(ProyectoU2MgApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola mundo");
		logJava.trace("Log TRACE");
		logJava.debug("Log DEBUG");
		logJava.info("Log INFO");
		logJava.warn("Log WARN");
		logJava.error("Log ERROR");
		logJava.fatal("Log FATAL");
	}

}
