package figures.circle;

import editor.Editor;
import editor.Figure;
import editor.tools.AbstractCreationTool;

public class CircleCreationTool extends AbstractCreationTool {
	public CircleCreationTool(Editor editor) {
		super(editor);
	}

	@Override
	public Figure createFigure() {
		return new Circle(inicio, inicio.x - fin.y); // suponiendo que siempre nos pasen la misma x e y
	}

}
