package com.cga.sanidad.dao;

import java.util.List;

import com.cga.sanidad.pojo.Paciente;

public interface PacienteDao {
	
	public boolean save (Paciente paciente);

	public List<Paciente> findAll();
	


}
