package observers;

import encuesta.*;

public class Backup implements VoteObserver {

	@Override
	public void votoRecibido(Pregunta encuesta) {
		System.out.println("\nBACKUP: Guardando resultados");
	}

}
