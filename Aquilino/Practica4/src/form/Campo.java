package form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import form.validators.Validator;

public class Campo {

	private String etiqueta;
	private Validator validador;

	public Campo(String etiqueta, Validator validador) {
		this.etiqueta = etiqueta;
		this.validador = validador;
	}

	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;
		do {
			valido = true;
			try {

				System.out.print(etiqueta + ": ");
				texto = consola.readLine();
				valido = validador.isValid(texto);

			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valido);
	}

	public String getDato() {
		return texto;
	}

	private String texto;

}
