package form.validators.decorate;

import form.validators.Validator;

public class AndValidator extends ComposeValidator implements Validator {

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
