package validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CompoundValidator implements Validator {

	protected List<Validator> validators = new ArrayList<>();

	public CompoundValidator(Validator... validators) {
		this.validators = Arrays.asList(validators);
	}

	public void addCondition(Validator validator) {
		if (validator == null)
			throw new IllegalArgumentException("�No se puede a�adir una condici�n nula a un validador compuesto!");
		validators.add(validator);
	}

}
