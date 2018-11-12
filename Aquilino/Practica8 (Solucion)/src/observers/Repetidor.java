package observers;

import encuesta.*;

public class Repetidor implements VoteObserver {

	public Repetidor(int frecuencia, VoteObserver otherObserver) {
		this.otherObserver = otherObserver;
		this.contador = this.frecuencia = frecuencia;
	}

	@Override
	public void votoRecibido(Pregunta encuesta) {
		if (contador == frecuencia) {
			otherObserver.votoRecibido(encuesta);
			contador = 1;
		} else
			contador++;
	}

	private int contador, frecuencia;
	private VoteObserver otherObserver;
}

// Qué patrón es este?