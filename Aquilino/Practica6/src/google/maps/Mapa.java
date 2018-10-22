package google.maps;

import java.awt.Rectangle;
import java.util.*;

public class Mapa {
	private List<Marcador> marcadores = new ArrayList<Marcador>();

	public void add(Marcador element) {
		marcadores.add(element);
	}

	public void dibujar() {
		// 1. Aqu� se dibujar�a el mapa
			// Ejercicio opcional para casa :)
		
		// 2. Y ahora se dibujar�an los marcadores encima
		for (Marcador marcador : marcadores)
			System.out.println("Marcador rojo en " + marcador.getCoordenadas());
	}

	public void pulsaci�nCorta(int x, int y) {
		Marcador marcador = buscaMarcador(x, y);
		if (marcador != null)
			System.out.println("Ventana flotante: " + marcador.getTooltipInfo());
	}

	public void pulsaci�nLarga(int x, int y) {
		Marcador marcador = buscaMarcador(x, y);
		if (marcador != null)
			marcador.abrir();
	}
	

	// M�todo auxiliar privado ----------------------
	private Marcador buscaMarcador(int x, int y) {
		for (Marcador marcador : marcadores) {
			Coordenadas coordenadas = marcador.getCoordenadas();
			Rectangle elementArea = new Rectangle((int) coordenadas.getLongitud(), (int) coordenadas.getLatitud(), 9, 9);
			if (elementArea.contains(x, y))
				return marcador;
		}
		return null;
	}

}
