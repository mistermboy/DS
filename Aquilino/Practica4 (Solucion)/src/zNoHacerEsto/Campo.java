package zNoHacerEsto;
import java.io.*;

public abstract class Campo {

	public Campo(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		do {
			try {
				System.out.print(etiqueta + ": ");
				texto = consola.readLine();
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!isValid(texto));
	}

	protected abstract boolean isValid(String texto2) ;

	public String getDato() {
		return texto;
	}

	private String texto;
	private String etiqueta;
}
