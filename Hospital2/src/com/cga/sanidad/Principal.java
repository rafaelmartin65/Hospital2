package com.cga.sanidad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		
		ApplicationContext parametros = new ClassPathXmlApplicationContext("ConfigSpring.xml");
		
		PacienteDao pacienteDao = (PacienteDao) parametros.getBean("PacienteDao");
		
		
		
		Paciente pac = (Paciente) parametros.getBean("pac");
		
		System.out.println(pacienteDao.save(pac));
		
		System.out.println(pac + "\n");
		pac.imprimirHistorial();
		
		
		
		
		((ClassPathXmlApplicationContext)parametros).close();
	
		}
		
		
	
}
