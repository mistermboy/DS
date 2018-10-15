package validaciones;

import formulario.*;

public class CheckGreater implements Validation {

	private int limite;

	public CheckGreater(int limite) {
		this.limite = limite;
	}

	public boolean isValid(String texto) {
		return Integer.parseInt(texto) > limite;
	}

}
