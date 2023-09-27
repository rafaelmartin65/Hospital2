package com.cga.sanidad.dao;

import java.util.List;

import com.cga.sanidad.pojo.Paciente;

public interface PacienteDao {
	
	// Método para agregar un paciente
	public boolean save (Paciente paciente);

	// Métedo listar todos
	public List<Paciente> findAll();
	
	//Método buscar por id
	public Paciente findById(int id);
	
	// Método buscar por nombre 
	public List<Paciente> findByNombre(String nombre);
	
	//Método update
	public boolean update(Paciente pac);
	
	//Método delete
	public boolean delete(int idPaciente);
	
	// Método saveAll
	public int[] saveAll(List<Paciente> paciente);
	
	
	

}
