package editor;

import java.util.*;

public class Dibujo {

	public Dibujo() {

	}

	public Dibujo(List<Figura> figuras) {
		this.figuras = figuras;
	}

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

	public Dibujo clone() {
		return new Dibujo(new ArrayList<>(figuras));
	}

	List<Figura> figuras = new ArrayList<Figura>();

}
