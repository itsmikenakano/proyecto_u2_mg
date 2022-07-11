package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.IVehiculoJpaRepository;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;

@Service
public class VehiculoJpaServiceImpl implements IVehiculoJpaService {

	@Autowired
	private IVehiculoJpaRepository iVehiculoJpaRepository;

	@Override
	public void insertar(Vehiculo v) {
		this.iVehiculoJpaRepository.insertar(v);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		return this.iVehiculoJpaRepository.buscarPorPlaca(placa);
	}

	@Override
	public void actualizar(Vehiculo v) {
		this.iVehiculoJpaRepository.actualizar(v);
	}

	@Override
	public int eliminarPorPlaca(String placa) {
		return this.iVehiculoJpaRepository.eliminarPorPlaca(placa);
	}

}
