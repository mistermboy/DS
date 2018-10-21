package figures.rectangle;

import editor.Editor;
import editor.Figure;
import editor.tools.AbstractCreationTool;

public class RectangleCreationTool extends AbstractCreationTool {

	public RectangleCreationTool(Editor editor) {
		super(editor);
	}

	@Override
	public Figure createFigure() {
		return new Rectangle(inicio, fin.x, fin.y);
	}


}
