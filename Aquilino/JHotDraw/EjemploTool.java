package CH.ifa.draw.samples.nada;

import CH.ifa.draw.framework.DrawingView;
import CH.ifa.draw.standard.CreationTool;

public class EjemploTool extends CreationTool {

	public EjemploTool(DrawingView view) {
		super(view, new EjemploFigure());
	}

}
