package figures;

import java.awt.Point;

import javax.swing.AbstractButton;

public abstract class AbstractFigure implements Figure {

	private Point point;
	private int ancho;
	private int alto;

	private StringBuilder datos = new StringBuilder();

	public AbstractFigure() {

	}

	public AbstractFigure(Point point, int ancho, int alto) {
		this.point = point;
		this.ancho = ancho;
		this.alto = alto;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public String toString() {
		datos.append(especificString());
		datos.append(": x = " + getPoint().getX() + ", y = " + getPoint().getY() + ", ancho = " + getAncho()
				+ ", alto = " + getAlto());
		return datos.toString();
	}

	public abstract String especificString();

	@Override
	public abstract void draw();

	@Override
	public void soltar(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}

}
