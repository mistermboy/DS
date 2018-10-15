package figures.triangle;

import java.awt.Point;

import editor.Editor;
import editor.Tool;

public class TriangleCreationTool implements Tool {

	private Editor editor;
	private Point[] vertice = new Point[3];
	private int vertices = 0;

	public TriangleCreationTool(Editor editor) {
		super();
		this.editor = editor;
	}

	@Override
	public void pinchar(int x, int y) {
		vertice[vertices++] = new Point(x, y);
		if (vertices == 3) {
			editor.getDibujo().addFigure(new Triangle(vertice[0], vertice[1], vertice[2]));
			vertices = 0;
			// editor.finHerramienta();
		}

	}

	@Override
	public void soltar(int x, int y) {
	}

	@Override
	public void mover(int x, int y) {
	}

}
