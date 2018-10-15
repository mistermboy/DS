package validaciones;

import formulario.*;

public class CheckLess implements Validation {

	private int limite;

	public CheckLess(int limite) {
		this.limite = limite;
	}

	public boolean isValid(String texto) {
		return Integer.parseInt(texto) < limite;
	}

}
