package com.cga.sanidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.cga.sanidad.dao.PacienteDao;
import com.cga.sanidad.pojo.Paciente;


public class Principal {

	static String nombre, apellidos, historial, edad, telefono;
	
	
	
	public static void main(String[] args) {
		
		// Se crea objeto scanner
		Scanner sc = new Scanner(System.in);
		

		ApplicationContext parametros = new ClassPathXmlApplicationContext("ConfigSpring.xml");
		PacienteDao pacienteDao = (PacienteDao) parametros.getBean("PacienteDao");
		
		
		
		// Crear una lsita de pacientes con ArrayList
		//List<Paciente> pacientes = new ArrayList<Paciente>();
		//pacientes.add(new Paciente("Ana","Gutierrez Monte", 35, 659867325, null, "privado"));
		//pacientes.add(new Paciente("Alberto","Moreno Herrera", 45, 659867325, null, "privado"));
		//pacientes.add(new Paciente("Margarita","Tabares Perez", 32, 659867325, null, "privado"));
		
		//pacienteDao.saveAll(pacientes);
		
		//int [] valores = pacienteDao.saveAll(pacientes);
		//for (int i : valores) {
		//	System.out.println(("Filas insertadas "
		//			+ "en la tabla paciente: " + i));
		//}
		
		//for (int i = 0; i < valores.length; i++) {
		//	System.out.println("Filas insertadas OKOKOK: "
		//			+ i + " " + pacientes.get(i));
		//}
		
		
		
		// Despliega menu y se guarda la opci�n elegida
		System.out.println("Elije una opci�n del menu\n");
		System.out.println("1. Agregar un paciente");
		System.out.println("2. Agregar un paciente");
		System.out.println("3. A�adir varios pacientes");
		int opcion = sc.nextInt();
		
		
		// Realizar el procedimiento seg�n opci�n elegida
		switch (opcion) {
			case 1:
				//System.out.println("opci�n 1");
				
				Paciente pac = incluirPaciente();
				
				// Se agregan los datos a la base de datos
				System.out.println("A�adiendo datos a la base de datos... " + pacienteDao.save(pac));
				
				break;
				
			case 2:
				System.out.println("opci�n 2");
				break;
				
			case 3:
				System.out.println("opci�n 3");
				break;
				
			default:
				System.out.println("Opci�n erronea");
				break;
		}
			
		
		
		
		
		
		//Paciente pac = (Paciente) parametros.getBean("pac");
		
		
		
		
		try {
			// comentar agregar pacientes
			//pacienteDao.save(pac);
			
			//Consulta todos los pacientes
			List<Paciente> pacientesLista = pacienteDao.findAll();
			
			for (Paciente paciente2 : pacientesLista) {
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
			System.out.println("Credenciales, Configuraci�n!!! ");
			e.printStackTrace();
			
		}catch (DataAccessException ex) {
			System.out.println("Error en SQL!!!");
			ex.printStackTrace();
			
		
		}


		((ClassPathXmlApplicationContext) parametros).close();

	}
	
	public static Paciente incluirPaciente() {
		
		Paciente pac = new Paciente();
		
		nombre = JOptionPane.showInputDialog("Introduce el nombre paciente");
		pac.setNombre(nombre);
		
		apellidos = JOptionPane.showInputDialog("Introduce los apellidos paciente");
		pac.setApellidos(apellidos);
		
		edad = JOptionPane.showInputDialog("Introduce edad del paciente");
		int edad1 = Integer.parseInt(edad);
		pac.setEdad(edad1);
		
		telefono = JOptionPane.showInputDialog("Introduce el telefono del paciente");
		int telefono1 = Integer.parseInt(telefono);
		pac.setTelefono(telefono1);

		historial = JOptionPane.showInputDialog("Introduce el historial paciente");
		pac.setHistorial(historial);
		
		Paciente paciente = new Paciente(nombre, apellidos, edad1, telefono1, null, historial);
		// Se muestran por pantalla los datos obtenidos
		System.out.println("*** Imprimir datos capturados: *** " + pac);
		
		
		return pac;
				
	}

	
}

 
