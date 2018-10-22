package figuras.cuadrado;

import java.awt.Point;

import editor.*;
import editor.herramientas.HerramientaCreacion;


public class HerramientaCuadrado extends HerramientaCreacion {

	public HerramientaCuadrado(Editor editor) {
		super(editor);
	}

	protected Figura doCreaFigura(Point inicio, Point fin) {
		return new Cuadrado(inicio, fin);
	}
}
