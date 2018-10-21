package figures.rectangle;

import java.awt.Point;

import editor.Figure;

public class Rectangle implements Figure {

	private Point point;
	private int ancho;
	private int alto;

	public Rectangle(Point point, int ancho, int alto) {
		super();
		this.point = point;
		this.ancho = ancho;
		this.alto = alto;
	}

	@Override
	public void draw() {
		if (point != null && ancho != 0 && alto != 0)
			System.out.println(toString());
		else
			System.out.println("Cuadrado");

	}

	public String toString() {
		return "Cuadrado: x = " + point.getX() + ", y = " + point.getY() + ", ancho = " + ancho + ", alto = " + alto;
	}

	@Override
	public void move(int x, int y) {
		point.translate(x, y);
	}

	@Override
	public boolean isContent(int x, int y) {
		return (point.x <= x && x <= point.x + ancho) && (point.y <= y && y <= point.y + alto);
	}

}
