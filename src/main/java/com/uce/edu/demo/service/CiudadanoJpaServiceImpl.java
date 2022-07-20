package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoJpaRepository;
import com.uce.edu.demo.repository.modelo.Ciudadano;

@Service
public class CiudadanoJpaServiceImpl implements ICiudadanoJpaService{
	
	@Autowired
	private ICiudadanoJpaRepository iCiudadanoJpaRepository;
	
	@Override
	public void insertar(Ciudadano c) {
		this.iCiudadanoJpaRepository.insertar(c);
		
	}

}
