package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {
	

	private int fila;
	private char columna;
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		if (fila >= 1 || fila <= 8) { 
			throw new IllegalArgumentException ("ERROR: La fila tiene que ser mayor que 0 y menor que 9"); 
		}else {
			this.fila = fila;
		}
	}
	public char getColumna() {
		return columna;
	}
	public void setColumna(char columna) {
		if (columna >= 'a' || columna <= 'h') { 
			throw new IllegalArgumentException ("ERROR: La columna tiene que ser estar entre la a y h"); 
		}else {
			this.columna = columna;
	}
}
	//Constructores
	//Constructor posicion de entrada
	public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	
	// Constructor copia
	public Posicion (Posicion pos) {
		if (pos == null) //Comprobación de que sea nulo posicion 
		{
			throw new NullPointerException("ERROR: No es posible copiar una posición nula."); //Lanzar la excepción
		}
		setFila(pos.getFila()); //Si no es nulo se asigna automáticamente del set validado
		setColumna(pos.getColumna());
	}
	//Metodo hashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}
	
	//Metodo toString
	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}
	
	
	
	
}
