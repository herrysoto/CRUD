package com.herry.soto.main;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import com.herry.soto.bean.Persona;
import com.herry.soto.dao.DAOPersonImpl;
import com.herry.soto.interfaces.DAOPersona;

public class Main {

	public static void main(String[] args) throws Exception {
		Persona per = new Persona();
		DAOPersona daop = new DAOPersonImpl();
		int opcion,numero1,numero2;
		double resultado;
		Scanner teclado = new Scanner(System.in);
		System.out.println("1.Se realiza el ingreso de un nuevo empleado");
		System.out.println("2.Se realiza la modificacion del nombre del empleado mediante su ID");
		System.out.println("3.Se realiza la eliminacion de un empleado seleccionado");
		System.out.println("4.Se obtiene la lista de empleados con sus IDs");
		System.out.println();
		System.out.println("Escoger la opción");
		opcion = teclado.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.println("Ingrese el ID de la persona a ingresar: ");
			String id = teclado.next();
			System.out.println("Ingrese el nombre de la persona: ");
			String nombre = teclado.next();
			per.setId(id);
			per.setNombre(nombre);
			
			//insertar datos a la tabla pruebabd
			try {
				daop.registrar(per);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			System.out.println("Ingrese el ID de la persona a quien quiere actualizar: ");
			String idact = teclado.next();
			System.out.println("Ingrese el nombre de la persona a actualizar: ");
			String nombreact = teclado.next();
			per.setId(idact);
			per.setNombre(nombreact);		
			daop.editar(per);
			System.out.println("Persona actualizada");
			break;
		case 3:
			System.out.println("Ingrese el ID de la persona a quien quiere eliminar: ");
			String ideli = teclado.next();
			per.setId(ideli);	
			daop.eliminar(per);
			System.out.println("Persona con el id "+per.getId()+" fue eliminada");
			break;
		case 4:
			//listar los datos de la tabla pruebabd
					try {
						for (Persona p : daop.listar()) {
							System.out.println("Nombre: "+p.getNombre()+"  |||  " +"ID : "+ p.getId());
						}
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
			break;

		default:
			System.out.println("Erro en opción");
			break;
		}
		

		
		
		
		
		
		
		
		
	}

}
