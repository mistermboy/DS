package observers;

import encuesta.*;

public class GraficoDeBarras implements VoteObserver {

	@Override
	public void votoRecibido(Pregunta encuesta) {
		System.out.println("\nDibujando grafico de barras");
		int gvs=encuesta.getVotosSi();
		int gvn=encuesta.getVotosNo();
		System.out.print("SI: ");
		while (gvs > 0){
			System.out.print("X");
			gvs--;
		}
		System.out.print("\nNO: ");
		while (gvn > 0){
			System.out.print("X");
			gvn--;
		}
		System.out.println("\nFin gráfico de barras");	}

}
