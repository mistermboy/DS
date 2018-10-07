package editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import figures.Figure;

public class Dibujo {

	List<Figure> figures = new ArrayList<Figure>();

	public void dibujar() {
		for (Figure f : figures)
			f.draw();
	}

	public void addFigure(Figure figure) {
		figures.add(figure);
	}

	public void getSelection(Point point) {
		for (Figure f : figures) {

		}
	}

	public List<Figure> getFigures() {
		return figures;
	}

}
