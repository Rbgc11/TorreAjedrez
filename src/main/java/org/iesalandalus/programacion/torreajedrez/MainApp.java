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
	
	//Metodo mostrarMenu
	private static void mostrarMenu() { 
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre de un color.");
		System.out.println("3. Crear una torre de un color en una columna inicial dada ('c' o 'f'), ");
		System.out.println("4. Mover la torre.");
		System.out.println("5. Salir.");
	}
	
	//Metodo elegirOpcion
		private static int elegirOpcion() {
			int opcionMenu;
			do {
				System.out.print("Por favor, elija una opción del menú: ");
				opcionMenu = Entrada.entero();
			} while (opcionMenu<1 || opcionMenu>5);
			return opcionMenu;	
		}
		
		//Metodo elegirColor
		private static Color elegirColor() {
			Color color=null;
			int opcionColor=0;
			do {
				System.out.println("===============");
				System.out.println("1. Blancas.");
				System.out.println("2. Negras.");
				System.out.print("Escoge un color: ");
				opcionColor=Entrada.entero();
			} while (opcionColor!=1 && opcionColor!=2);
			
			switch (opcionColor) {
			case 1:
				color=Color.BLANCO;
				break;
			case 2:
				color=Color.NEGRO;
				break;
			}
			
			return color;
		}
		
		//Metodo elegirColumnaInicial
		private static char elegirColumnaInicial() {
			char columna = 0;
			
			do {
				System.out.print("Introduzca la columna deseada ('C' o 'F'): ");
				columna=Entrada.caracter();
			} while (columna!='a' && columna!='A' && columna!='h' && columna!='H');
		
			return columna;
		}
	
}
