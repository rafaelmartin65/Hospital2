package com.cga.sanidad.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.cga.sanidad.pojo.Paciente;


@Component("PacienteDao")
public class PacienteDaoImpl implements PacienteDao {
	
	
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public boolean save(Paciente paciente) {
		
		MapSqlParameterSource parametros = new MapSqlParameterSource();
		
		//parametros.addValue("idPaciente", paciente.getIdPaciente());
		parametros.addValue("nombre", paciente.getNombre());
		parametros.addValue("apellidos", paciente.getApellidos());
		parametros.addValue("edad", paciente.getEdad());
		parametros.addValue("telefono", paciente.getTelefono());
		//parametros.addValue("direccion", null);
		parametros.addValue("historial", paciente.getHistorial());
		
	
		
		return jdbcTemplate.update("insert into paciente "  
				+ "values (null, :nombre, :apellidos, :edad, :telefono, null, :historial)", parametros) == 1;
	}



	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
