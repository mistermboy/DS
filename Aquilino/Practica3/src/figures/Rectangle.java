package figures;

import java.awt.Point;

public class Rectangle implements Figure {

	private Point point;
	private int ancho;
	private int alto;

	public Rectangle() {
	}

	@Override
	public void draw() {
		if (point != null && ancho != 0 && alto != 0)
			System.out.println(toString());
		else
			System.out.println("Cuadrado");

	}

	@Override
	public void pinchar(Point point) {
		this.point = point;
	}

	@Override
	public void soltar(int x, int y) {
		this.ancho = x;
		this.alto = y;
	}

	@Override
	public boolean esPinchada(int x, int y) {
		return (point.x <= x && x <= point.x + ancho) && (point.y <= y && y <= point.y + alto);
	}

	public String toString() {
		return "Cuadrado: x = " + point.getX() + ", y = " + point.getY() + ", ancho = " + ancho + ", alto = " + alto;
	}

}
