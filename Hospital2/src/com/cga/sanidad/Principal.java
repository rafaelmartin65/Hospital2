package com.cga.sanidad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext apc = new ClassPathXmlApplicationContext("ConfigSpring.xml");
		
		PacienteDao pacienteDao = (PacienteDao) apc.getBean("dataSource");
		System.out.println(pacienteDao);
		
		
		Paciente pac = (Paciente) apc.getBean("pac");
		
		pac.imprimirHistorial();
		
		System.out.println(pac);
		
		if (pacienteDao.save(pac)) {
			System.out.println("Paciente guardado!!");
		}else {
			System.out.println("Error al inseertar el paciente");
		}
		
		
		((ClassPathXmlApplicationContext)apc).close();
	
		}
		
		
	
}
