package observadores;

import encuesta.Pregunta;

public class Alternar implements Observer {

	private Observer observer;
	private int iterador;

	public Alternar(Observer observer, int iterador) {
		this.observer = observer;
		this.iterador = iterador;
	}

	@Override
	public void notify(Pregunta pregunta) {
		if ((pregunta.getVotosTotales() + 2) % iterador == 0)
			observer.notify(pregunta);
	}

}
