package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.IMatriculaJpaRepository;
import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.prueba.repository.IVehiculoJpaRepository;
import com.uce.edu.demo.prueba.repository.modelo.Matricula;
import com.uce.edu.demo.prueba.repository.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService {

	@Autowired
	private IPropietarioJpaRepository iPropietarioJpaRepository;

	@Autowired
	private IVehiculoJpaRepository iVehiculoJpaRepository;

	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;

	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;

	@Autowired
	private IMatriculaJpaRepository iMatriculaJpaRepository;

	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario propietario = this.iPropietarioJpaRepository.consultarPorCedula(cedula);
		Vehiculo vehiculo = this.iVehiculoJpaRepository.buscarPorPlaca(placa);
		String tipo = vehiculo.getTipo();
		BigDecimal valorMatricula;
		if (tipo.equals("Pesado")) {
			valorMatricula = this.matriculaServicePesado.calcular(vehiculo.getPrecio());

		} else {
			valorMatricula = this.matriculaServiceLiviano.calcular(vehiculo.getPrecio());
		}

		if (valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal valorDescuento = valorMatricula.multiply(new BigDecimal(0.07));
			valorMatricula = valorMatricula.subtract(valorDescuento);
		}

		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValorMatricula(valorMatricula);
		matricula.setPropietario(propietario);
		matricula.setVehiculo(vehiculo);

		this.iMatriculaJpaRepository.insertar(matricula);
	}

}
