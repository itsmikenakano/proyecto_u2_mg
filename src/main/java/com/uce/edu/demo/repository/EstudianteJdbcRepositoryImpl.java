package com.uce.edu.demo.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.Estudiante;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static Logger LOG = Logger.getLogger(EstudianteJdbcRepositoryImpl.class);

	@Override
	public void insertar(Estudiante e) {
		LOG.info("Se ha insertado en la base el estudiante: " + e);
		this.jdbcTemplate.update("insert into estudiante (id, nombre, apellido, genero, edad) values (?,?,?,?,?)",
				new Object[] { e.getId(), e.getNombre(), e.getApellido(), e.getGenero(), e.getEdad() });
	}

	@Override
	public Estudiante buscarPorId(int id) {
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void actualizar(Estudiante e) {
		LOG.info("Se ha actualizado en la base el estudiante: " + e);
		this.jdbcTemplate.update("update estudiante set nombre=?, apellido=?, edad=?, genero=? where id=?",
				new Object[] { e.getNombre(), e.getApellido(), e.getEdad(), e.getGenero(), e.getId() });

	}

	@Override
	public void eliminar(int id) {
		LOG.info("Se elimino el estudiante con id: " + id);
		this.jdbcTemplate.update("delete from estudiante where id=?", new Object[] { id });
	}

}
