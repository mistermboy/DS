package observadores;

import java.io.StringWriter;

import encuesta.Pregunta;

public class GraficoBarras implements Observer {

	private StringWriter stringwriter;

	@Override
	public void notify(Pregunta pregunta) {

		stringwriter = new StringWriter();
		stringwriter.append("SI: ");
		for (int i = 0; i < pregunta.getVotosSi(); i++)
			stringwriter.append("X");
		stringwriter.append("\nNO: ");
		for (int j = 0; j < pregunta.getVotosNo(); j++)
			stringwriter.append("X");

		// UI
		System.out.println();
		System.out.println(stringwriter.toString());
		System.out.println("Fin gráfico de barras");
		System.out.println();

	}

}
