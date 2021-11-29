package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;


public class Torre {
	//Atributos
	private Color color;
	private Posicion posicion;
	
	//Constructor por defecto
	public Torre() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8,'h'));
	}
	
	//Constructor con entrada de color
	public Torre(Color color) {
		setColor(color);
		if (color.equals(Color.BLANCO))
		{
			setPosicion(new Posicion(1,'h'));
		} else
		{
			setPosicion(new Posicion(8,'h'));
		}
	}
	
	//Constructor que acepte como parámetros el color y columna inicial
	public Torre(Color color, char columna) {
		setColor(color);
		
		if ( columna=='a' || columna == 'h'  ) 
		{
			if (color.equals(Color.BLANCO)) 
			{
				setPosicion(new Posicion(1,columna));
			} else
			{
				setPosicion(new Posicion(8,columna));
			}
		} else
			throw new IllegalArgumentException("ERROR: Columna no válida.");
	}
	// Método Mover 
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException{
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		} else if  (pasos < 1 ) { 	
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo."); 
		}
	int fila = posicion.getFila(); 
	int columna = posicion.getColumna(); 
	if (color == Color.NEGRO) { 
		switch (direccion) { 
		case ARRIBA: 
			try {
				setPosicion(new Posicion(fila - pasos , posicion.getColumna()));
			} catch (IllegalArgumentException pos) {
				throw new OperationNotSupportedException("ERROR: Movimiento no valido (se sale del tablero).");
			}
		case ABAJO: 
			try {
				setPosicion(new Posicion(fila + pasos , posicion.getColumna()));
			} catch (IllegalArgumentException pos) {
				throw new OperationNotSupportedException("ERROR: Movimiento no valido (se sale del tablero).");
			} 
		case IZQUIERDA: 
			try {
				setPosicion(new Posicion(fila , (char)(columna +pasos)));
			} catch (IllegalArgumentException pos) {
				throw new OperationNotSupportedException("ERROR: Movimiento no valido (se sale del tablero).");
			}
		case DERECHA: 
			try {
				setPosicion(new Posicion(posicion.getFila() , (char)(columna -pasos)));
			} catch (IllegalArgumentException pos) {
				throw new OperationNotSupportedException("ERROR: Movimiento no valido (se sale del tablero).");
			}
			default:
			break;
			} 
		}else {
			switch (direccion) {
			case ARRIBA:
				try {
					setPosicion(new Posicion(fila + pasos , posicion.getColumna()));
				} catch (IllegalArgumentException pos) {
					throw new OperationNotSupportedException("ERROR: Movimiento no valido (se sale del tablero).");
				}
			case ABAJO: 
				try {
					setPosicion(new Posicion(fila - pasos , posicion.getColumna()));
				} catch (IllegalArgumentException pos) {
					throw new OperationNotSupportedException("ERROR: Movimiento no valido (se sale del tablero).");
				}
			case IZQUIERDA: 
				try {
					setPosicion(new Posicion(fila, (char)(columna - pasos)));
				} catch (IllegalArgumentException pos) {
					throw new OperationNotSupportedException("ERROR: Movimiento no valido (se sale del tablero).");
				}
			case DERECHA:
				try {
					setPosicion(new Posicion(fila , (char)(columna +pasos)));
				} catch (IllegalArgumentException pos) {
					throw new OperationNotSupportedException("ERROR: Movimiento no valido (se sale del tablero).");
				}
				default: 
					break; 
			} 
			throw new NullPointerException("ERROR: La direccion no puede ser nula");
		}
	}
	//Metodo Enrocar
	public void enrocar (Direccion direccionCorrecta) throws OperationNotSupportedException {
		if (direccionCorrecta==null) {
			throw new NullPointerException("ERROR: La direccion no puede ser nula.");
		}
		if (direccionCorrecta == Direccion.ENROQUE_CORTO) {
			if (posicion.getColumna()=='h' && (posicion.getFila()==1 && color==Color.BLANCO) || (posicion.getFila()==8 && color==Color.NEGRO))
			{
				setPosicion(new Posicion(posicion.getFila(),'f'));
			} else 
			{
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no valido.");
			}
			
		}else{
			if (posicion.getColumna()=='a' && (posicion.getFila()==1 && color== Color.BLANCO) || (posicion.getFila()==8  && color==Color.NEGRO))
			{
				setPosicion(new Posicion(posicion.getFila(),'d'));
			}else 
			{
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no valido.");
			} 
	
		}
	}
	//Constructores
	public Color getColor() {
	return color;
	}
	public void setColor(Color color) {
	this.color = color;
	}
	public Posicion getPosicion() {
	return posicion;
	}
	public void setPosicion(Posicion posicion) {
	this.posicion = posicion;
	}
}

	
