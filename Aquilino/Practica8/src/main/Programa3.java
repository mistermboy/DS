package main;

import java.io.IOException;

import encuesta.Pregunta;
import encuesta.TextUserInterface;
import observadores.GraficoCircular;
import observadores.Delay;
import observadores.LineaEstado;

public class Programa3 {

	public static void main(String[] args) throws IOException {

		Pregunta encuesta = new Pregunta("¿Está a favor de la energia nuclear?");
		encuesta.addObservador(new Delay(new GraficoCircular(), 3));
		encuesta.addObservador(new LineaEstado());

		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);

	}

}
