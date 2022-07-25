package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Album;
import com.uce.edu.demo.repository.modelo.onetomany.Artista;
import com.uce.edu.demo.service.IAlbumService;
import com.uce.edu.demo.service.IArtistaService;

@SpringBootApplication
public class ProyectoU2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2MgApplication.class);

	@Autowired
	private IArtistaService iArtistaService;
	
	@Autowired
	private IAlbumService iAlbumService;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//insertar
		Artista art=new Artista();
		art.setNombre("Elvis Crespo");
		art.setEdad("50");
		
		this.iArtistaService.insertar(art);
		
		Artista artId = new Artista();
		artId.setId(1);
		
		Album album= new Album();
		album.setNombre("Un verano sin ti");
		album.setGenero("Reggaeton");
		album.setFechaLanzamiento(LocalDateTime.now());
		album.setArtista(artId);
		this.iAlbumService.insertar(album);
		
		//consultar
		LOG.info("Artista: " + this.iArtistaService.consultar(1));
		
		//actualizar
		art.setEdad("28");
		this.iArtistaService.actualizar(art);
		
		//eliminar
		this.iArtistaService.eliminar(2);
	}

}
