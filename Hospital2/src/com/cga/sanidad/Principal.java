package com.cga.sanidad;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.cga.sanidad.dao.PacienteDao;
import com.cga.sanidad.dao.PacienteDaoImpl;
import com.cga.sanidad.pojo.Paciente;


public class Principal {

	
	
	public static void main(String[] args) {
		
		

		ApplicationContext parametros = new ClassPathXmlApplicationContext("ConfigSpring.xml");

		PacienteDao pacienteDao = (PacienteDao) parametros.getBean("PacienteDao");
		
		
		// Se crea el objeto paciente
		Paciente paciente = new Paciente();
		
		// Se realiza la captura por pantalla de los datos
		paciente = pacienteDao.capturaDatos(paciente);
		
		// Se muestran por pantalla los datos obtenidos
		System.out.println("Imprimir datos capturados: " + paciente);
		
		// Se agregan los datos a la base de datos
		System.out.println("Añadiendo datos ala base de datos... " + pacienteDao.save(paciente));
		
		//Paciente pac = (Paciente) parametros.getBean("pac");
		
		
		
		
		try {
			// comentar agregar pacientes
			//pacienteDao.save(pac);
			
			//Consulta todos los pacientes
			List<Paciente> pacientes = pacienteDao.findAll();
			
			for (Paciente paciente2 : pacientes) {
				System.out.println("Mostrar: " + paciente2);
				
			}
			
			//consulta por nombre
			List<Paciente> pacientes01 = pacienteDao.findByNombre("Pepito");
			
			for (Paciente paciente3 : pacientes01) {
				System.out.println("Nombre = Pepito  " + paciente3);
				
			}
			
			//consulta por id
			System.out.println("Paciente con id: " + pacienteDao.findById(10028));
			System.out.println("Paciente con id: " + pacienteDao.findById(10032));
			//System.out.println("Paciente comienza con 'P': \n" + pacienteDao.findByNombre("P").toString());
			
			// System.out.println("FindAll procedure: " + pacienteDao.findAll());
			
			
		}catch (CannotGetJdbcConnectionException e) {
			System.out.println("Credenciales, Configuración!!! ");
			e.printStackTrace();
			
		}catch (DataAccessException ex) {
			System.out.println("Error en SQL!!!");
			ex.printStackTrace();
			
		
		}


		((ClassPathXmlApplicationContext) parametros).close();

	}

}
