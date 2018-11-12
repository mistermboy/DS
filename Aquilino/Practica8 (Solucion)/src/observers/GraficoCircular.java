package observers;

import encuesta.*;

public class GraficoCircular implements VoteObserver {

	@Override
	public void votoRecibido(Pregunta encuesta) {
		double gvs=encuesta.getVotosSi();
		double gvn=encuesta.getVotosNo();
		double vsdegree=(gvs/(gvs+gvn))*360;
		double vndegree=(gvn/(gvs+gvn))*360;
		System.out.println("\nDibujando gráfico circular--> si: "+vsdegree+" grados no: "+vndegree+" grados");
	}

}
