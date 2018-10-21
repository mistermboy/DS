package editor.tools;

import java.awt.Point;

import editor.Editor;
import editor.Figure;
import editor.Tool;

public abstract class AbstractCreationTool implements Tool {

	private Editor editor;
	protected Point inicio, fin;

	public AbstractCreationTool(Editor editor) {
		super();
		this.editor = editor;
	}

	public void pinchar(int x, int y) {
		inicio = new Point(x, y);
	}

	public void soltar(int x, int y) {
		fin = new Point(x, y);
		editor.addFigure(createFigure());
		//finherramienta
	}

	@Override
	public void mover(int x, int y) {
	}

	public abstract Figure createFigure();

}
