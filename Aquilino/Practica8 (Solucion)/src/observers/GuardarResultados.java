package observers;

import encuesta.*;

public class GuardarResultados implements VoteObserver {

	@Override
	public void votoRecibido(Pregunta encuesta) {
		System.out.println("\nGUARDAR RESULTADOS: Guardando resultados");
	}

}
