package validaciones.composite;

import java.util.*;

import formulario.*;

public class CheckAll implements Validation {

	private List<Validation> validations;

	public CheckAll(Validation... validations) {
		this.validations = Arrays.asList(validations);
	}

	public boolean isValid(String texto) {
		for (Validation validacion : validations)
			if (!validacion.isValid(texto))
				return false;
		return true;
	}
}
