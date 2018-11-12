import java.io.*;

import observers.*;
import encuesta.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Pregunta encuesta = new Pregunta("�Est� a favor de la energia nuclear?");

		/*
		 * Detectar los puntos de mejora en el dise�o. Redise�arlo usando uno o m�s patrones.
		 * A partir de este punto no deber�a tener que modificarse la clase Pregunta para realizar
		 * el resto de las modificaciones.
		 */

		encuesta.addObserver(new GraficoDeBarras());
		encuesta.addObserver(new GraficoCircular());
		encuesta.addObserver(new GuardarResultados());

		/*
		 * 1. Hacer una nueva versi�n del programa que al recibir un voto tambi�n se dibuje una l�nea de estado.
		 * Una l�nea de estado es una l�nea de texto que indica el estado actual de la votaci�n
		 * (n� de votos SI = <x>. n� de votos NO = <y>).
		 */

		encuesta.addObserver(new LineaDeEstado());

		/*
		 * 2. Hacer una nueva versi�n del programa que no dibuje el gr�fico de barras.
		 */

		// Simplemente habr�a que comentar la l�nea siguiente en el c�digo anterior

		// encuesta.addObserver(new GraficoDeBarras());

		/*
		 * 3. Hacer otra versi�n del programa que, en vez de dibujarlo con cada voto, el gr�fico circular s�lo
		 * se dibuje a partir del tercer voto (y a partir de ah� se dibuje con cada voto).
		 */
		encuesta.addObserver(new Activador(3, new GraficoCircular()));

		/*
		 * 4. Hacer otra versi�n del programa en la que vuelva a estar el gr�fico de barras, pero ahora solo se
		 * dibujar� cada 3 votos (con el primero, cuarto, s�ptimo, etc�).
		 */
		encuesta.addObserver(new Repetidor(3, new GraficoDeBarras()));

		/*
		 * 5. Hacer una �ltima versi�n del programa en la que la l�nea de estado comience a imprimirse a partir
		 * del cuarto voto y a partir de ah� se imprima cada dos (se imprimir� en el cuarto,
		 * sexto, octavo, etc�).
		 */
		encuesta.addObserver(new Activador(4, new Repetidor(2, new LineaDeEstado())));

		// -------------------------------------------------------
		// Inicio del cuestionario
		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);
	}

}
