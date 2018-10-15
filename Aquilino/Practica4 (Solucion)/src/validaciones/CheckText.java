package validaciones;

import formulario.*;

public class CheckText implements Validation {

	public boolean isValid(String texto) {
		for (char ch : texto.toCharArray())
			if (!Character.isLetter(ch))
				return false;
		return true;
	}
}
