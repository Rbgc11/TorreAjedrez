package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	//Atributos
	private Color color;
	private Posicion posicion;
	
	//Constructor por defecto
	public Torre() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8,'h'));
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

	
