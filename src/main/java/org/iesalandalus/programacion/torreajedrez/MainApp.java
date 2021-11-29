package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	//Atributo Torre
	private static Torre torre;


	public static void main(String[] args) {
		int control=1;
		int seleccion;
		System.out.println("Torre Ajedrez");
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
	
}
