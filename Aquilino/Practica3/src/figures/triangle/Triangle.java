package figures.triangle;

import java.awt.Point;

import editor.Figure;

public class Triangle implements Figure {

	private Point v0;
	private Point v1;
	private Point v2;

	public Triangle(Point v0, Point v1, Point v2) {
		super();
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
	}

	@Override
	public void draw() {
		if (v0 != null && v1 != null && v2 != null)
			System.out.println(toString());
		else
			System.out.println("Triangulo");

	}

	public String toString() {
		return "Triangulo: v0 = " + v0 + ", v1 = " + v1 + ", v2 = " + v2;
	}

	@Override
	public void move(int x, int y) {
		v0.translate(x, y);
		v1.translate(x, y);
		v2.translate(x, y);
	}

	@Override
	public boolean isContent(int x, int y) {
		Point posicion = new Point(x, y);
		return posicion.equals(v0) || posicion.equals(v1) || posicion.equals(v2);
	}

}
