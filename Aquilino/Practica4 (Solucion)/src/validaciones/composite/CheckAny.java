package validaciones.composite;

import java.util.*;

import formulario.*;

public class CheckAny implements Validation {

	private List<Validation> validations;

	public CheckAny(Validation... validations) {
		this.validations = Arrays.asList(validations);
	}

	public boolean isValid(String texto) {
		for (Validation validacion : validations)
			if (validacion.isValid(texto))
				return true;
		return false;
	}
}
