package com.cga.sanidad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext apc = new ClassPathXmlApplicationContext("ConfigSpring.xml");
		
		
		
		Paciente pac = (Paciente) apc.getBean("pac");
		
		pac.imprimirHistorial();
		
		System.out.println(pac);
		
		
		
		((ClassPathXmlApplicationContext)apc).close();
	
		}
		
		
	
}
