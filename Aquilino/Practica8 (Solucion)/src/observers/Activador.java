package observers;

import encuesta.*;

public class Activador implements VoteObserver {

	public Activador(int cuentaAtras, VoteObserver otherObserver) {
		this.otherObserver = otherObserver;
		this.cuentaAtras = cuentaAtras;
	}

	@Override
	public void votoRecibido(Pregunta encuesta) {
		if (cuentaAtras == 1) {
			otherObserver.votoRecibido(encuesta);
		} else
			cuentaAtras--;
	}

	private int cuentaAtras;
	private VoteObserver otherObserver;
}

// Qué patrón es este?