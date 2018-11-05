package observadores;

import encuesta.Pregunta;

public class GraficoCircular implements Observer {

	@Override
	public void notify(Pregunta pregunta) {

		double vs = pregunta.getVotosSi();
		double vn = pregunta.getVotosNo();
		double gradosSi = (vs / (vs + vn)) * 360.0;
		double gradosNo = 360.0 - gradosSi;

		// UI
		System.out.println("Dibujando gráfico circular--> si: " + gradosSi + " grados no: " + gradosNo + " grados");
		System.out.println();

	}

}
