package main;
import java.io.*;

import observers.*;
import encuesta.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Pregunta encuesta = new Pregunta("�Est� a favor de la energia nuclear?");

		/*
		 * Nuevo Dise�o
		 */
		encuesta.addObserver(new GraficoDeBarras());
		encuesta.addObserver(new GraficoCircular());
		encuesta.addObserver(new Backup());

		/*
		 * Programa 1. Al recibir un voto tambi�n se tiene que dibujar una l�nea de estado.
		 * "n� de votos SI = <x>. n� de votos NO = <y>"
		 */
		encuesta.addObserver(new LineaDeEstado());


		/*
		 * Programa 2. Que no dibuje el gr�fico de barras.
		 */
		// encuesta.addObserver(new GraficoDeBarras()); 	// S�lo habr�a que comentar esta l�nea en el c�digo anterior


		/*
		 * Programa 3. En vez de dibujarlo con cada voto, el gr�fico circular s�lo
		 * se dibuja a partir del tercer voto (y a partir de ah� con cada voto).
		 */
		encuesta.addObserver(new Activador(3, new GraficoCircular()));

		
		/*
		 * Programa 4. Vuelva el gr�fico de barras, pero ahora solo se
		 * dibujar� cada 3 votos (con el primero, cuarto, s�ptimo, etc�).
		 */
		encuesta.addObserver(new Repetidor(3, new GraficoDeBarras()));

		
		/*
		 * Programa 5. La l�nea de estado debe comenzar a imprimirse a partir
		 * del cuarto voto y a partir de ah� se imprimar� cada dos
		 * (se imprimir� en el cuarto, sexto, octavo, etc�).
		 */
		encuesta.addObserver(new Activador(4, new Repetidor(2, new LineaDeEstado())));

		
		// -------------------------------------------------------
		// Inicio del cuestionario
		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);
	}

}
