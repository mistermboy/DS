package encuesta;

import java.util.ArrayList;
import java.util.List;

import observadores.Observer;

public class Pregunta {

	private int si, no;
	private String pregunta;

	private List<Observer> observadores;

	public Pregunta(String pregunta) {
		this.pregunta = pregunta;
		observadores = new ArrayList<>();
	}

	public String getPregunta() {
		return pregunta;
	}

	public int getVotosSi() {
		return si;
	}

	public int getVotosNo() {
		return no;
	}

	public int getVotosTotales() {
		return si + no;
	}

	public void incrementaSi() {
		si++;
		notificarObservadores();
	}

	public void incrementaNo() {
		no++;
		notificarObservadores();
	}

	private void notificarObservadores() {
		for (Observer o : observadores)
			o.notify(this);
	}

	public void addObservador(Observer observer) {
		observadores.add(observer);
	}

}
