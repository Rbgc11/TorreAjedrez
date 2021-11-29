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
		
		//Metodo mostrarMenuDirecciones
		private static void mostrarMenuDirecciones() {
			System.out.println("============================");
			System.out.println("1. Arriba.");
			System.out.println("2. Abajo.");
			System.out.println("3. Izquierda.");
			System.out.println("4. Derecha.");
			System.out.println("5. Enroque corto.");
			System.out.println("6. Enroque largo.");
			System.out.println("============================");
		}
	
		//Metodo elegirDireccion
		private static Direccion elegirDireccion() {
			Direccion direccion = null;
			int opcionDireccion = 0;
			
			do {
				System.out.print("Elija una opción entre las anteriores: ");
				opcionDireccion = Entrada.entero();
			} while (opcionDireccion<1 || opcionDireccion>6);
			
			switch (opcionDireccion) {
			case 1:
				direccion=Direccion.ARRIBA;
				break;
			case 2:
				direccion=Direccion.ABAJO;
				break;
			case 3:
				direccion=Direccion.IZQUIERDA;
				break;
			case 4:
				direccion=Direccion.DERECHA;
				break;
			case 5:
				direccion=Direccion.ENROQUE_CORTO;
				break;
			case 6:
				direccion=Direccion.ENROQUE_LARGO;
				break;
			}
			
			return direccion;
		}
		
		//Metodo crearTorreDefecto
		private static void crearTorreDefecto() {
			torre=new Torre();
		}
		
		//Metodo crearTorreColor
		private static void crearTorreColor() {
			torre=new Torre(elegirColor());
		}
		
		//Metodo crearTorreColorColumna
		private static void crearTorreColorColumna() {
			torre=new Torre(elegirColor(), elegirColumnaInicial());
		}
		
		//Metodo mover
		private static void mover() {
			Direccion direccion=null;
			int pasos;
			if (torre == null)
			{
				System.out.println("No existe la torre para mover.");
			} else 
			{
				mostrarMenuDirecciones();	
				direccion=elegirDireccion();
				
				if (direccion.equals(Direccion.ENROQUE_CORTO) || direccion.equals(Direccion.ENROQUE_LARGO)) {
					try {
						torre.enrocar(direccion);
					} catch (OperationNotSupportedException pos) {
						System.out.println(pos.getMessage());
					}
				} else
				{
					System.out.print("Introduzca la cantidad de pasos a dar: ");
					pasos = Entrada.entero();
					
					try {
						torre.mover(direccion, pasos);
					} catch (OperationNotSupportedException pos) {
						System.out.println(pos.getMessage());
					}
				}
			}
		}
		
		
}
