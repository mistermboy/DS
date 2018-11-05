package encuesta;
public class Pregunta {

	private int si, no;
	private String pregunta;

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

	public void incrementaSi() {
		si++;
		actualizaGráficoCircular();
		actualizaGráficoBarras();
		hacerBackup();
	}

	public void incrementaNo() {
		no++;
		actualizaGráficoCircular();
		actualizaGráficoBarras();
		hacerBackup();
	}


	// Parte de representar los datos
	private void actualizaGráficoCircular() {
		System.out.println("Aquí se dibujaría el gráfico circular.");
	}

	private void actualizaGráficoBarras() {
		System.out.println("Aquí se dibujaría el gráfico de barras.");
	}

	private void hacerBackup() {
		System.out.println("Aquí se guardarían los datos en disco/BD.");
	}

}
