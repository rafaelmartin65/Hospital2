package com.cga.sanidad.dao;

import java.util.List;

import com.cga.sanidad.pojo.Paciente;

public interface PacienteDao {
	
	// M�todo para agregar un paciente
	public boolean save (Paciente paciente);

	// M�tedo listar todos
	public List<Paciente> findAll();
	
	//M�todo buscar por id
	public Paciente findById(int id);
	
	// M�todo buscar por nombre 
	public List<Paciente> findByNombre(String nombre);
	
	//M�todo update
	public boolean update(Paciente pac);
	
	//M�todo delete
	public boolean delete(int idPaciente);
	
	// M�todo saveAll
	public int[] saveAll(List<Paciente> paciente);
	
	
	

}
