package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {

	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);

	public Persona buscarPorId(Integer id);

	public Persona buscarPorCedula(String cedula);

	public Persona buscarPorCedulaTyped(String cedula);

	public Persona buscarPorCedulaNamed(String cedula);

	public Persona buscarPorCedulaTypedNamed(String cedula);
	
	public Persona buscarPorCedulaNative(String cedula);
	
	public Persona buscarPorCedulaNamedNative(String cedula);

	public List<Persona> buscarPorApellido(String apellido);

	public List<Persona> buscarPorNombre(String nombre);
	
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);

	public List<Persona> buscarPorGenero(String genero);

	public int actualizarPorApellido(String genero, String apellido);

	public int eliminarPorGenero(String genero);

}
