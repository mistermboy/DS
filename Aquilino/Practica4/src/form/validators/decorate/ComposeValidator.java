package form.validators.decorate;

import form.validators.Validator;

public abstract class ComposeValidator implements Validator {

	protected Validator[] validators;

	public ComposeValidator(Validator... validators) {
		this.validators = validators;
	}

	public abstract boolean isValid(String texto);

}
