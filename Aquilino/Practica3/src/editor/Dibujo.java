package editor;

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

	public List<Figure> getFigures() {
		return figures;
	}

	public Figure getFigure(int x, int y) {
		for (Figure f : figures) {
			if (f.isContent(x, y)) {
				return f;
			}
		}
		return null;
	}

}
