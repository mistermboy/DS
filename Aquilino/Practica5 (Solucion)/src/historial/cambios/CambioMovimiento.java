package historial.cambios;

import editor.*;

public class CambioMovimiento implements Cambio {

	private Figura figura;
	private int dx;
	private int dy;

	public CambioMovimiento(Figura figura, int dx, int dy) {
		this.figura = figura;
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public void undo() {
		figura.mover(-dx, -dy);
	}

	@Override
	public void redo() {
		figura.mover(dx, dy);
	}

}
