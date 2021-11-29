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

	
