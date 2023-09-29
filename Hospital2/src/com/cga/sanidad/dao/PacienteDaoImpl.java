package com.cga.sanidad.dao;


import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cga.sanidad.pojo.Paciente;


@Component("PacienteDao")
public class PacienteDaoImpl implements PacienteDao {
	
	
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public boolean save(Paciente pacientes) {
		
		MapSqlParameterSource parametros = new MapSqlParameterSource();
		
		
		
		System.out.println("Datos en parametros: " + parametros.toString());
		
		//parametros.addValue("idPaciente", pacientes.getIdPaciente());
		parametros.addValue("nombre", pacientes.getNombre());
		parametros.addValue("apellidos", pacientes.getApellidos());
		parametros.addValue("edad", pacientes.getEdad());
		parametros.addValue("telefono", pacientes.getTelefono());
		//parametros.addValue("direccion", null);
		parametros.addValue("historial", pacientes.getHistorial());
		
	
		
		return jdbcTemplate.update("insert into pacientes "  
				+ "values (null, :nombre, :apellidos, :edad, :telefono, null, :historial)", parametros) == 1;
	}
	
	
	@Transactional
	@Override
	public int[] saveAll(List<Paciente> paciente) {
		SqlParameterSource[] batchArgs = 
				SqlParameterSourceUtils.
				createBatch(paciente.toArray());
		
			return jdbcTemplate.batchUpdate
					("insert into Pacientes "
					+ "(nombre, apellidos, edad, telefono, direccion, "
					+ "historial)"
					+ "Values (:nombre, :apellidos, :edad, :telefono,"
					+ ":direccion, :historial)", batchArgs);
	}
	
	

	@Override
	public List<Paciente> findAll() {
		 
		return jdbcTemplate.query("select * from pacientes", new PacienteRowMapper());
		
	}



	@Override
	public Paciente findById(int id) {
		// Consultar por id
		
		try {
			return jdbcTemplate.queryForObject("select * from Pacientes"
					+ " where idPaciente = :idPaciente", 
					new MapSqlParameterSource("idPaciente", id),
					new PacienteRowMapper());
		}catch (EmptyResultDataAccessException e) {
			//Handle exception
			System.out.println("id nonono");
		}
		return null;
	}



	@Override
	public List<Paciente> findByNombre(String nombre) {
		// Consulta por nombre
		return jdbcTemplate.query("select * from pacientes"
				+ " where nombre like :nombre", 
				new MapSqlParameterSource("nombre", "%" + nombre + "%"),
				new PacienteRowMapper());
	}



	@Override
	public boolean update(Paciente pac) {
		// Método de actualización paciente
		return jdbcTemplate.update("update "
				+"Paciente set nombre=:nombre, apellidos=:apellidos, "
				+ "edad=:edad, telefono=:telefono, "
				+ "historial=:historial "
				+ "where idPaciente=:idPaciente",
				new BeanPropertySqlParameterSource(pac)) == 1;
	}



	@Override
	public boolean delete(int idPaciente) {
		// Método de borrado paciente
		return jdbcTemplate.update("delete from Pacientes where "
				+ "idPaciente=:idPaciente",
				new MapSqlParameterSource("idPaciente", idPaciente)) == 1;
	}



	
	
}
