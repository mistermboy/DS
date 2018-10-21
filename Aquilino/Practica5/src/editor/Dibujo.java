package editor;

import java.util.*;

import actions.ActionManager;

public class Dibujo {

	List<Figura> figuras = new ArrayList<Figura>();

	private Figura currentSelection;
	private ActionManager actionManager = new ActionManager();

	public void AddFigura(Figura figura) {
		figuras.add(figura);
	}

	public void dibuja() {
		for (Figura figura : figuras)
			figura.dibujar();
	}

	public Figura getFigura(int x, int y) {
		for (Figura figura : figuras)
			if (figura.contiene(x, y))
				return figura;
		return null;
	}

	public void removeFigure(Figura figura) {
		figuras.remove(figura);
	}

	public void clearCurrentSelection() {
		currentSelection = null;
	}

	public Figura getCurrentSelection() {
		return currentSelection;
	}

	public void setCurrentSelection(Figura figure) {
		currentSelection = figure;
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

}
