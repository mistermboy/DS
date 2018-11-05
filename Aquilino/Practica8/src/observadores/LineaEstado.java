package observadores;

import encuesta.Pregunta;

public class LineaEstado implements Observer {

	@Override
	public void notify(Pregunta pregunta) {
		System.out.println("VOTOS RECIBIDOS: Si = " + pregunta.getVotosSi() + "/ NO = " + pregunta.getVotosNo());
	}

}
