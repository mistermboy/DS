package main;

import java.io.IOException;

import encuesta.Pregunta;
import encuesta.TextUserInterface;
import observadores.GraficoBarras;
import observadores.Alternar;
import observadores.GraficoCircular;
import observadores.LineaEstado;

public class Programa4 {

	public static void main(String[] args) throws IOException {

		Pregunta encuesta = new Pregunta("¿Está a favor de la energia nuclear?");
		encuesta.addObservador(new GraficoCircular());
		encuesta.addObservador(new Alternar(new GraficoBarras(), 3));
		encuesta.addObservador(new LineaEstado());

		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);

	}
}
