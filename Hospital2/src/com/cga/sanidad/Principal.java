package com.cga.sanidad;

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
			
			pacienteDao.save(pac);
			
		}catch (CannotGetJdbcConnectionException e) {
			System.out.println("Credenciales, Confuiguración!!! ");
			e.printStackTrace();
			
		}catch (DataAccessException ex) {
			System.out.println("Error en SQL!!!");
			ex.printStackTrace();
			
		
		}

		System.out.println(pac + "\n");
		pac.imprimirHistorial();

		((ClassPathXmlApplicationContext) parametros).close();

	}

}
