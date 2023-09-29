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
		
		
		
		// Crear una lista de pacientes con ArrayList
		List<Paciente> pacientes = new ArrayList<Paciente>();
		pacientes.add(new Paciente("Alberto","Moreno Herrera", 45, 658789459, null, "privado"));
		pacientes.add(new Paciente("Margarita","Tabares Perez", 32, 687596325, null, "privado"));
		pacientes.add(new Paciente("Ana","Gutierrez Monte", 35, 659867324, null, "privado"));
		System.out.println(pacientes.toString());
		
		try {
			pacienteDao.saveAll(pacientes);
		}catch (Exception e) {
			System.out.println("Error ***\n" + e.getMessage() + "\n");
		}
			
		
		//int [] valores = pacienteDao.saveAll(pacientes);
		//for (int i : valores) {
		//	System.out.println(("Filas insertadas "
		//			+ "en la tabla paciente: " + i));
		//}
		
		//for (int i = 0; i < valores.length; i++) {
		//	System.out.println("Filas insertadas OKOKOK: "
		//			+ i + " " + pacientes.get(i));
		//}
		
		
		
		// Despliega menu y se guarda la opción elegida
		System.out.println("Elije una opción del menu\n");
		System.out.println("1. Agregar un paciente");
		System.out.println("2. Eliminar un paciente");
		System.out.println("3. Añadir varios pacientes");
		System.out.println("4. Consultar paciente por id");
		System.out.println("5. Consultar paciente por nombre");
		System.out.println("6. Consultar todos los pacientes");
		System.out.println("\n9. Salir ");
		
		int opcion = sc.nextInt();
		
		
		// Realizar el procedimiento según opción elegida
		switch (opcion) {
			case 1:
				//System.out.println("opción 1");
				
				Paciente pac = incluirPaciente();
				
				// Se agregan los datos a la base de datos
				System.out.println("Añadiendo datos a la base de datos... " + pacienteDao.save(pac));
				
				break;
				
			case 2:
				System.out.println("opción 2");
				break;
				
			case 3:
				System.out.println("opción 3");
				break;
				
			case 4:
				//consultar pacinte por id
				System.out.println("Paciente con id: " + pacienteDao.findById(10028));
				
			case 5:
				//consulta por nombre
				List<Paciente> pacientes01 = pacienteDao.findByNombre("Pepito");
				
			case 6: 
				//Consulta todos los pacientes
				List<Paciente> pacientesLista = pacienteDao.findAll();
				
			case 9:
				//Salir de la ejecución
				System.out.println("Fin del programa****");
				System.exit(0);
				
			default:
				System.out.println("Opción erronea");
				break;
		}
			
		
		
		
			//System.out.println("Paciente comienza con 'P': \n" + pacienteDao.findByNombre("P").toString());
			
			
			
//		}catch (CannotGetJdbcConnectionException e) {
//			System.out.println("Credenciales, Configuración!!! ");
//			e.printStackTrace();
//			
//		}catch (DataAccessException ex) {
//			System.out.println("Error en SQL!!!");
//			ex.printStackTrace();
//			
//		
//		}


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

 
