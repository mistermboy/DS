package figures;

import java.awt.Point;

public class Triangle implements Figure {

	private Point v0;
	private Point v1;
	private Point v2;

	public Triangle() {
	}

	public Triangle(Point v0, Point v1, Point v2) {
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
	}

	public Point getV0() {
		return v0;
	}

	public void setV0(Point v0) {
		this.v0 = v0;
	}

	public Point getV1() {
		return v1;
	}

	public void setV1(Point v1) {
		this.v1 = v1;
	}

	public Point getV2() {
		return v2;
	}

	public void setV2(Point v2) {
		this.v2 = v2;
	}

	@Override
	public void draw() {
		if (getV0() != null && getV1() != null && getV2() != null)
			System.out.println(toString());
		else
			System.out.println("Triangulo");

	}

	@Override
	public void pinchar(Point point) {

		if (getV0() == null)
			setV0(point);
		else {
			if (getV1() == null)
				setV1(point);
			else {
				if (getV2() == null)
					setV2(point);
			}

		}

	}

	public String toString() {
		return "Triangulo: v0 = " + getV0() + ", v1 = " + getV1() + ", v2 = " + getV2();
	}

	@Override
	public void soltar(int ancho, int alto) {

	}

}
