package editor;

import java.util.*;

public class Historial {

	public void añadeCambio(Cambio change) {
		undos.push(change);
		redos.clear();
	}

	public void undo() {
		if (undos.isEmpty()) {
			System.out.println("Traza: no es posible hacer undo");
			return;
		}
		Cambio change = undos.pop();
		change.undo();
		redos.push(change);
	}

	public void redo() {
		if (redos.isEmpty()) {
			System.out.println("Traza: no es posible hacer redo");
			return;
		}
		Cambio cambio = redos.pop();
		cambio.redo();
		undos.push(cambio);
	}

	private Stack<Cambio> undos = new Stack<Cambio>();
	private Stack<Cambio> redos = new Stack<Cambio>();
}
