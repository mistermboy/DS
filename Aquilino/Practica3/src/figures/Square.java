package figures;

import java.awt.Point;

public class Square extends AbstractFigure implements Figure {

	public Square() {
	}

	public Square(Point point, int ancho, int alto) {
		super(point, ancho, alto);
	}

	@Override
	public void draw() {
		if (getPoint() != null && getAncho() != 0 && getAlto() != 0)
			System.out.println(toString());
		else
			System.out.println("Cuadrado");

	}

	@Override
	public void pinchar(Point point) {
		setPoint(point);
	}

	@Override
	public String especificString() {
		return "Cuadrado";
	}

}
