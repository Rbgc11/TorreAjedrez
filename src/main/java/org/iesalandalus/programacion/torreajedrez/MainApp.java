package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	//Atributo Torre
	private static Torre torre;


	public static void main(String[] args) {
		int control=1;
		int seleccion;
		System.out.println("=====================================");
		System.out.println("Torre Ajedrez");
		System.out.println("=====================================");

		do {
			mostrarMenu();
			seleccion=elegirOpcion();
			ejecutarOpcion(seleccion);
			mostrarTorre();
			
			if (seleccion==5) {
				control=0;
			}
		} while (control!=0);
	}
	
	//Metodo mostrarTorre
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException pos){
			System.out.println("ERROR: La torre no fue creada.");
		}
	}
	
}
