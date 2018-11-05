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
		actualizaGr�ficoCircular();
		actualizaGr�ficoBarras();
		hacerBackup();
	}

	public void incrementaNo() {
		no++;
		actualizaGr�ficoCircular();
		actualizaGr�ficoBarras();
		hacerBackup();
	}


	// Parte de representar los datos
	private void actualizaGr�ficoCircular() {
		System.out.println("Aqu� se dibujar�a el gr�fico circular.");
	}

	private void actualizaGr�ficoBarras() {
		System.out.println("Aqu� se dibujar�a el gr�fico de barras.");
	}

	private void hacerBackup() {
		System.out.println("Aqu� se guardar�an los datos en disco/BD.");
	}

}
