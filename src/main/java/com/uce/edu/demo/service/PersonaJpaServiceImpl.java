package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {

	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository;

	@Override
	public void guardar(Persona persona) {
		this.iPersonaJpaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		this.iPersonaJpaRepository.actualizar(persona);

	}

	@Override
	public void eliminar(Integer id) {
		this.iPersonaJpaRepository.eliminar(id);

	}

	@Override
	public Persona buscarPorId(Integer id) {
		return this.iPersonaJpaRepository.buscarPorId(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaTypedNamed(cedula);
	}

	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaNamedNative(cedula);
	}

	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedulaCriteriaApi(cedula);
	}

	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		return this.iPersonaJpaRepository.buscarDinamicamente(nombre, apellido, genero);
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		return this.iPersonaJpaRepository.buscarPorApellido(apellido);
	}

	@Override
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido) {
		return this.iPersonaJpaRepository.buscarPorApellidoSencillo(apellido);
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		return this.iPersonaJpaRepository.consultarCantidadPorGenero();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		return this.iPersonaJpaRepository.buscarPorNombre(nombre);
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		return this.iPersonaJpaRepository.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		return this.iPersonaJpaRepository.buscarPorGenero(genero);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {

		return this.iPersonaJpaRepository.actualizarPorApellido(genero, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		return this.iPersonaJpaRepository.eliminarPorGenero(genero);
	}

}
