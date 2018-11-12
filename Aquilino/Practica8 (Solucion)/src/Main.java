import java.io.*;

import observers.*;
import encuesta.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Pregunta encuesta = new Pregunta("¿Está a favor de la energia nuclear?");

		/*
		 * Detectar los puntos de mejora en el diseño. Rediseñarlo usando uno o más patrones.
		 * A partir de este punto no debería tener que modificarse la clase Pregunta para realizar
		 * el resto de las modificaciones.
		 */

		encuesta.addObserver(new GraficoDeBarras());
		encuesta.addObserver(new GraficoCircular());
		encuesta.addObserver(new GuardarResultados());

		/*
		 * 1. Hacer una nueva versión del programa que al recibir un voto también se dibuje una línea de estado.
		 * Una línea de estado es una línea de texto que indica el estado actual de la votación
		 * (nº de votos SI = <x>. nº de votos NO = <y>).
		 */

		encuesta.addObserver(new LineaDeEstado());

		/*
		 * 2. Hacer una nueva versión del programa que no dibuje el gráfico de barras.
		 */

		// Simplemente habría que comentar la línea siguiente en el código anterior

		// encuesta.addObserver(new GraficoDeBarras());

		/*
		 * 3. Hacer otra versión del programa que, en vez de dibujarlo con cada voto, el gráfico circular sólo
		 * se dibuje a partir del tercer voto (y a partir de ahí se dibuje con cada voto).
		 */
		encuesta.addObserver(new Activador(3, new GraficoCircular()));

		/*
		 * 4. Hacer otra versión del programa en la que vuelva a estar el gráfico de barras, pero ahora solo se
		 * dibujará cada 3 votos (con el primero, cuarto, séptimo, etc…).
		 */
		encuesta.addObserver(new Repetidor(3, new GraficoDeBarras()));

		/*
		 * 5. Hacer una última versión del programa en la que la línea de estado comience a imprimirse a partir
		 * del cuarto voto y a partir de ahí se imprima cada dos (se imprimirá en el cuarto,
		 * sexto, octavo, etc…).
		 */
		encuesta.addObserver(new Activador(4, new Repetidor(2, new LineaDeEstado())));

		// -------------------------------------------------------
		// Inicio del cuestionario
		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);
	}

}
