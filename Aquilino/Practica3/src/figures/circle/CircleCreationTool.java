package figures.circle;

import editor.Editor;
import figures.Figure;
import tools.AbstractCreationTool;

public class CircleCreationTool extends AbstractCreationTool {
	public CircleCreationTool(Editor editor) {
		super(editor);
	}

	@Override
	public Figure createFigure() {
		return new Circle(inicio, inicio.x - fin.y); // suponiendo que siempre nos pasen la misma x e y
	}

}
