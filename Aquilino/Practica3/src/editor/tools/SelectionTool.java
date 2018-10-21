package editor.tools;

import java.awt.Point;

import editor.Editor;
import editor.Figure;
import editor.Tool;

public class SelectionTool implements Tool {

	private Editor editor;
	private Point position;
	private Figure selection;

	public SelectionTool(Editor editor) {
		super();
		this.editor = editor;
	}

	@Override
	public void pinchar(int x, int y) {
		selection = editor.getDibujo().getFigure(x, y);
		position = new Point(x, y);
	}

	@Override
	public void mover(int x, int y) {
		moveIncrease(x, y);
	}

	@Override
	public void soltar(int x, int y) {
		moveIncrease(x, y);
	}

	private void moveIncrease(int x, int y) {
		if (selection != null) {
			selection.move(x - position.x, y - position.y);
			position = new Point(x, y);
		}
	}

}
