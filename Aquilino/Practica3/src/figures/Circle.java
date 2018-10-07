package figures;

import java.awt.Point;

public class Circle implements Figure {

	private Point point;
	private int radio;

	public Circle() {
	}

	@Override
	public void draw() {
		if (point != null && radio != 0)
			System.out.println(toString());
		else
			System.out.println("Circulo");

	}

	@Override
	public void pinchar(Point point) {
		this.point = point;
	}

	@Override
	public void soltar(int x, int y) {
		this.radio = (point.x - y); // suponiendo que siempre nos pasen la misma x e y
	}

	@Override
	public boolean esPinchada(int x, int y) {
		double distancia = Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
		return distancia < radio;
	}

	public String toString() {
		return "Circulo: x = " + point.getX() + ", y = " + point.getY() + ", circulo: " + radio;
	}

}
