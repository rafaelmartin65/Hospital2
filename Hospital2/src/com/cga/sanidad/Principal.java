package com.cga.sanidad;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.cga.sanidad.dao.PacienteDao;
import com.cga.sanidad.pojo.Paciente;


public class Principal {

	public static void main(String[] args) {

		ApplicationContext parametros = new ClassPathXmlApplicationContext("ConfigSpring.xml");

		PacienteDao pacienteDao = (PacienteDao) parametros.getBean("PacienteDao");

		Paciente pac = (Paciente) parametros.getBean("pac");
		
		//System.out.println(pacienteDao.save(pac));
		
		
		
		try {
			// comentar agregar pacientes
			//pacienteDao.save(pac);
			
			List<Paciente> pacientes = pacienteDao.findAll();
			
			for (Paciente paciente2 : pacientes) {
				System.out.println("Mostrar: " + paciente2);
				
			}
			
			// System.out.println("FindAll procedure: " + pacienteDao.findAll());
			
			
		}catch (CannotGetJdbcConnectionException e) {
			System.out.println("Credenciales, Confuiguración!!! ");
			e.printStackTrace();
			
		}catch (DataAccessException ex) {
			System.out.println("Error en SQL!!!");
			ex.printStackTrace();
			
		
		}

		// System.out.println(pac + "\n");
		pac.imprimirHistorial();

		((ClassPathXmlApplicationContext) parametros).close();

	}

}
