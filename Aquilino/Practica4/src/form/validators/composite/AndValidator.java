package form.validators.composite;

import form.validators.Validator;

public class AndValidator extends ComposeValidator implements Validator {

	public AndValidator(Validator... validators) {
		super(validators);
	}

	@Override
	public boolean isValid(String texto) {
		for (Validator v : validators) {
			if (!v.isValid(texto)) {
				return false;
			}
		}
		return true;
	}

}
