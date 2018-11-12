package encuesta;

import java.util.*;

public class Pregunta {

	public Pregunta(String pregunta) {
		this.pregunta = pregunta;
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

	public void addObserver(VoteObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(VoteObserver observer) {
		observers.remove(observer);
	}

	public void incrementaSi() {
		si++;
		avisaAObservers();
	}

	public void incrementaNo() {
		no++;
		avisaAObservers();
	}

	private void avisaAObservers() {
		for (VoteObserver voteObserver : observers)
			voteObserver.votoRecibido(this);
	}

	private int si, no;
	private String pregunta;
	private List<VoteObserver> observers = new ArrayList<>();
}
