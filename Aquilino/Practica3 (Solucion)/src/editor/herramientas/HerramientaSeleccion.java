package editor.herramientas;

import java.awt.Point;

import editor.*;


public class HerramientaSeleccion implements Herramienta {

	private Point posicion;

	public HerramientaSeleccion(Editor editor) {
		this.editor = editor;
	}

	public void pinchar(int x, int y) {
		seleccionada = editor.getDibujo().getFigura(x, y);
		posicion = new Point(x, y);
	}

	public void mover(int x, int y) {
		mueveIncremento(x, y);
	}

	public void soltar(int x, int y) {
		mueveIncremento(x, y);
	}

	private void mueveIncremento(int x, int y) {
		if (seleccionada != null) {
			seleccionada.mover(x - posicion.x, y - posicion.y);
			posicion = new Point(x, y);
		}
	}

	private Editor editor;
	private Figura seleccionada;
}
