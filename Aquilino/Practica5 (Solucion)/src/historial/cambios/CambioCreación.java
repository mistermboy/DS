package historial.cambios;

import editor.*;

public class CambioCreaci�n implements Cambio {

	private Figura figura;
	private Dibujo dibujo;

	public CambioCreaci�n(Dibujo dibujo, Figura figura) {
		this.figura = figura;
		this.dibujo =  dibujo;
	}

	public void undo() {
		dibujo.removeFigura(figura);
	}

	public void redo() {
		dibujo.addFigura(figura);
	}

}
