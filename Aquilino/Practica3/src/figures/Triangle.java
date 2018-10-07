package figures;

import java.awt.Point;

public class Triangle implements Figure {

	private Point v0;
	private Point v1;
	private Point v2;

	public Triangle() {
	}

	@Override
	public void draw() {
		if (v0 != null && v1 != null && v2 != null)
			System.out.println(toString());
		else
			System.out.println("Triangulo");

	}

	@Override
	public void pinchar(Point point) {

		if (v0 == null)
			v0 = point;
		else {
			if (v1 == null)
				v1 = point;
			else {
				if (v2 == null)
					v2 = point;
			}

		}

	}


	@Override
	public void soltar(int ancho, int alto) {

	}

	@Override
	public boolean esPinchada(int x, int y) {
		Point posicion = new Point(x, y);
		return posicion.equals(v0) || posicion.equals(v1) || posicion.equals(v2);

	}

	public String toString() {
		return "Triangulo: v0 = " + v0 + ", v1 = " + v1 + ", v2 = " + v2;
	}
	
}
