package validaciones;

import formulario.*;

public class CheckLength implements Validation {

	public CheckLength(int longitud) {
		this.longitud = longitud;
	}

	public boolean isValid(String texto) {
		return texto.length() == longitud;
	}

	private int longitud;
}
