package validaciones;

import formulario.*;

public class CheckValues implements Validation {

	public CheckValues(String... valores) {
		this.valores = valores;
	}

	public boolean isValid(String texto) {
		for (String valor : valores)
			if (texto.toLowerCase().equals(valor.toLowerCase()))
				return true;
		return false;
	}

	private String[] valores;
}
