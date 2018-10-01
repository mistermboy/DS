package editor;

import java.awt.Point;

import figures.Figure;

public class Editor {

	private Dibujo dibujo;
	private Figure selectionTool;

	public Editor(Dibujo dibujo) {
		setDibujo(dibujo);
	}

	public void setDibujo(Dibujo dibujo) {
		this.dibujo = dibujo;
	}

	public Dibujo getDibujo() {
		return dibujo;
	}

	public void dibujar() {
		dibujo.dibujar();
	}

	public void addFigure(Figure figure) {
		selectionTool = figure;
		dibujo.addFigure(figure);
	}

	public void pinchar(Point points) {
		selectionTool.pinchar(points);
	}

	public void soltar(int ancho, int alto) {
		selectionTool.soltar(ancho, alto);
	}

}
