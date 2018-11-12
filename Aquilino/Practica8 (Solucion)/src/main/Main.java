package main;
import java.io.*;

import observers.*;
import encuesta.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Pregunta encuesta = new Pregunta("¿Está a favor de la energia nuclear?");

		/*
		 * Nuevo Diseño
		 */
		encuesta.addObserver(new GraficoDeBarras());
		encuesta.addObserver(new GraficoCircular());
		encuesta.addObserver(new Backup());

		/*
		 * Programa 1. Al recibir un voto también se tiene que dibujar una línea de estado.
		 * "nº de votos SI = <x>. nº de votos NO = <y>"
		 */
		encuesta.addObserver(new LineaDeEstado());


		/*
		 * Programa 2. Que no dibuje el gráfico de barras.
		 */
		// encuesta.addObserver(new GraficoDeBarras()); 	// Sólo habría que comentar esta línea en el código anterior


		/*
		 * Programa 3. En vez de dibujarlo con cada voto, el gráfico circular sólo
		 * se dibuja a partir del tercer voto (y a partir de ahí con cada voto).
		 */
		encuesta.addObserver(new Activador(3, new GraficoCircular()));

		
		/*
		 * Programa 4. Vuelva el gráfico de barras, pero ahora solo se
		 * dibujará cada 3 votos (con el primero, cuarto, séptimo, etc…).
		 */
		encuesta.addObserver(new Repetidor(3, new GraficoDeBarras()));

		
		/*
		 * Programa 5. La línea de estado debe comenzar a imprimirse a partir
		 * del cuarto voto y a partir de ahí se imprimará cada dos
		 * (se imprimirá en el cuarto, sexto, octavo, etc…).
		 */
		encuesta.addObserver(new Activador(4, new Repetidor(2, new LineaDeEstado())));

		
		// -------------------------------------------------------
		// Inicio del cuestionario
		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);
	}

}
