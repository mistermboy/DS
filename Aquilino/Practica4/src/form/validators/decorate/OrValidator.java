package form.validators.decorate;

import form.validators.Validator;

public class OrValidator extends ComposeValidator implements Validator {

	public OrValidator(Validator... validators) {
		super(validators);
	}
	
	@Override
	public boolean isValid(String texto) {
		for (Validator v : validators) {
			if (v.isValid(texto)) {
				return true;
			}
		}
		return false;
	}

}
