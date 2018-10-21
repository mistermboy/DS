package figures.circle;

import java.awt.Point;

import editor.Figure;

public class Circle implements Figure {

	private Point point;
	private int radio;

	public Circle(Point point, int radio) {
		super();
		this.point = point;
		this.radio = radio;
	}

	@Override
	public void draw() {
		if (point != null && radio != 0)
			System.out.println(toString());
		else
			System.out.println("Circulo");

	}

	public String toString() {
		return "Circulo: x = " + point.getX() + ", y = " + point.getY() + ", circulo: " + radio;
	}

	@Override
	public void move(int x, int y) {
		point.translate(x, y);
	}

	@Override
	public boolean isContent(int x, int y) {
		double distancia = Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
		return distancia < radio;
	}

}
