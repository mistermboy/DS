package observadores;

import encuesta.Pregunta;

public class Delay implements Observer {

	private Observer observer;
	private int delay;

	public Delay(Observer observer, int delay) {
		this.observer = observer;
		this.delay = delay;
	}

	@Override
	public void notify(Pregunta pregunta) {
		if (pregunta.getVotosTotales() > delay)
			observer.notify(pregunta);
	}

}
