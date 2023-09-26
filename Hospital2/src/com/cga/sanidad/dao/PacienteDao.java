package com.cga.sanidad.dao;

import java.util.List;

import com.cga.sanidad.pojo.Paciente;

public interface PacienteDao {
	
	// Método para agregar un paciente
	public boolean save (Paciente paciente);

	public List<Paciente> findAll();
	
	public Paciente findById(int id);
	
	public List<Paciente> findByNombre(String nombre);
	
	public boolean update(Paciente pac);
	public boolean delete(int idPaciente);
	
	public Paciente capturaDatos(Paciente paciente);
	
	//public int[] saveAll(List<Paciente> paciente);
	
	
	

}
