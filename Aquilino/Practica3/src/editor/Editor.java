package editor;

import java.awt.Point;

import figures.Figure;

public class Editor {

	private Dibujo dibujo;
	private Figure selectionTool;
	private boolean isSelection;

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
		isSelection = false;
	}

	public void pinchar(Point point) {

		if (!isSelection)
			selectionTool.pinchar(point);
		else
			seleccionar(point);
	}

	public void mover(Point point) {
		selectionTool.pinchar(point);
	}

	public void activateSelection() {
		isSelection = true;
	}

	public void soltar(int x, int y) {
		selectionTool.soltar(x, y);
	}

	private void seleccionar(Point point) {
		for (Figure f : dibujo.getFigures()) {
			if (f.esPinchada(point.x, point.y))
				selectionTool = f;

		}
	}

}
